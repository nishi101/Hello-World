package net.naturesnap.apiclient;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.HttpClients;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.naturesnap.apiclient.http.requests.Request;
import net.naturesnap.apiclient.http.results.Code;
import net.naturesnap.apiclient.http.results.Result;
import sun.misc.IOUtils;

public class Interface {
	public static BasicCookieStore cookieStore = new BasicCookieStore();
	public static HttpClient httpClient=null;
	public static Result request(Request request, String... paramValues){
		String content = apiRequest(request, paramValues);
		return responseData(request, content);
	}
	public static String apiRequest(Request request, String[] paramValues){
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
					String content = new String(IOUtils.readFully(entity.getContent(), (int)entity.getContentLength(), false));
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
					String content = new String(IOUtils.readFully(entity.getContent(), (int)entity.getContentLength(), false));
					response.close();
					return content;
				} catch (ClientProtocolException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
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
