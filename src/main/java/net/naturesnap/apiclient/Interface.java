package net.naturesnap.apiclient;

import java.io.File;
import java.io.IOException;

import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.client.*;
import cz.msebera.android.httpclient.client.methods.CloseableHttpResponse;
import cz.msebera.android.httpclient.client.methods.HttpPost;
import cz.msebera.android.httpclient.client.methods.HttpUriRequest;
import cz.msebera.android.httpclient.client.methods.RequestBuilder;
import cz.msebera.android.httpclient.entity.ContentType;
import cz.msebera.android.httpclient.entity.mime.HttpMultipartMode;
import cz.msebera.android.httpclient.entity.mime.MultipartEntityBuilder;
import cz.msebera.android.httpclient.entity.mime.content.FileBody;
import cz.msebera.android.httpclient.impl.client.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.naturesnap.apiclient.http.requests.Request;
import net.naturesnap.apiclient.http.results.Code;
import net.naturesnap.apiclient.http.results.Result;
import org.apache.commons.io.IOUtils;

public class Interface {
	public static final BasicCookieStore cookieStore = new BasicCookieStore();
	public static HttpClient httpClient=null;
	public static Result request(Request request, String... paramValues){
		String content = apiRequest(request, paramValues);
		return responseData(request, content);
	}
	public static String apiRequest(Request request, String... paramValues){
		if(httpClient==null){
			httpClient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
		}
		RequestBuilder reqBuilder;
		HttpUriRequest get, post;
		switch(request.type){
			case GET:
				reqBuilder = RequestBuilder.get("http://naturesnap.net/"+request.getEndpoint());
				for(int i=0;i<request.getParams().length;i++){
					reqBuilder.addParameter(request.getParams()[i], paramValues[i]);
				}
				get = reqBuilder.build();
				try {
					CloseableHttpResponse response = (CloseableHttpResponse) httpClient.execute(get);
					HttpEntity entity = response.getEntity();
					String content = IOUtils.toString(entity.getContent(), "UTF-8");
					response.close();
					return content;
				} catch (ClientProtocolException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			break;
			case POST:
				reqBuilder = RequestBuilder.post().setUri("http://naturesnap.net/"+request.getEndpoint());
				for(int i=0;i<request.getParams().length;i++){
					reqBuilder.addParameter(request.getParams()[i], paramValues[i]);
				}
				post = reqBuilder.build();
				try {
					CloseableHttpResponse response = (CloseableHttpResponse) httpClient.execute(post);
					HttpEntity entity = response.getEntity();
					String content = IOUtils.toString(entity.getContent(), "UTF-8");
					response.close();
					return content;
				} catch (ClientProtocolException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			break;
			case FILE:
				HttpPost postFile = new HttpPost("http://naturesnap.net/"+request.getEndpoint());
				File file = new File(request.getParams()[0]);
				FileBody fileBody = new FileBody(file);
				MultipartEntityBuilder builder = MultipartEntityBuilder.create();
				builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
				builder.addPart("filename", fileBody);
				builder.addTextBody("uploadForm","Upload");
				builder.addTextBody("latitude",request.getParams()[1]);
				builder.addTextBody("longitude",request.getParams()[2]);
				builder.addTextBody("groupName","");
				builder.addTextBody("description","");
				HttpEntity entity = builder.build();
				postFile.setEntity(entity);
				try {
					HttpResponse response = httpClient.execute(postFile);
					return IOUtils.toString(response.getEntity().getContent(), "UTF-8");
				}catch(Exception e){

				}
			break;
			default:
				// Error
			break;
		}
		
		return "";
	}
	public static Result responseData(Request request, String content){
		switch(request.format){
			case CODE:
				return new Code(content);
			case JSON:
				ObjectMapper mapper = new ObjectMapper();
				try {
					return (Result) mapper.readValue(content, request.getResult());
				} catch (JsonProcessingException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				}
			break;
			default:
				System.out.println("ERROR");
			break;
		}
		return null;
	}
}
