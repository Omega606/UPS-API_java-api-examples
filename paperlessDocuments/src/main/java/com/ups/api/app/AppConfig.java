package com.ups.api.app;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import lombok.Data;

@Configuration
@Data
public class AppConfig {
	
	public static final int SCENARIO_PROPERTIES_JSON_FILE_NAME = 0;
	public static final int SCENARIO_PROPERTIES_CLASS_NAME = 1;
	
	@Value("${api.oauth.partner.client.id}")
	private String clientID;
	
	@Value("${api.oauth.partner.secret}")
	private String secret;
	
	@Value("${api.oauth.base.url}")
	private String oauthBaseUrl;

	// store access token obtaining by client_credential grant_type.
	private Map<String,String> accessTokenStore = new ConcurrentHashMap<>();
	
	@Value("${api.paperlessDocuments.base.url:#{null}}")
	private String paperlessDocumentsBaseUrl;
	
	@Value("${api.paperlessDocuments.version:v1}")
	private String paperlessDocumentsVersion;

	@Value("${api.paperlessDocuments.shipperNumber}")
	private String shipperNumber;

	@Value("${api.paperlessDocuments.documentId}")
	private String documentId;
	
	@Value("${api.paperlessDocuments.transaction.source:testing}")
	private String transactionSrc;
	
	@Value("#{${api.uploadDocuments.scenario.properties}}")
	private Map<String,List<String>> uploadDocumentScenarioProperties;

	@Value("#{${api.uploadImages.scenario.properties}}")
	private Map<String,List<String>> uploadImageScenarioProperties;

	@Value("${api.oauth.access.token.expiry.tolerance:5}")
	private long tokenExipryToleranceInSec;

	public static final String UPLOAD_DOCUMENTS_SUCCESS_SCENARIO = "uploadDocumentsSuccess";

	public static final String UPLOAD_IMAGE_SUCCESS_SCENARIO = "uploadImageSuccess";

	
	@Bean 
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		final SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
		return builder.requestFactory(() -> factory).build();
	}
}
