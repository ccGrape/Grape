package com.doubleC.grape.business.find.urlregex;

import android.app.Activity;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.doubleC.grape.R;

public class UrlRegexWebViewActivity extends Activity{
	private WebView web;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.web);
		extractUidFromUri();
		web = (WebView) findViewById(R.id.web);
		
		web.setWebViewClient(new WebViewClient(){
			@Override
			public void onPageFinished(WebView view, String url) {
				super.onPageFinished(view, url);
			}
			
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				if (url.indexOf("http") == 0 
						|| url.indexOf("https") == 0
						|| url.indexOf("www") == 0) {
					view.loadUrl(url);
				}
				return true;
			}
			
			@Override
			public void onPageStarted(WebView view, String url, Bitmap favicon) {
				super.onPageStarted(view, url, favicon);
			}
			
		});
		
		web.setWebChromeClient(new WebChromeClient(){
			@Override
			public void onProgressChanged(WebView view, int newProgress) {
				super.onProgressChanged(view, newProgress);
				//可以在此加载进度条
			}
		});
		
		web.loadUrl(uid);
	}
	private String uid;
	private static final Uri PROFILE_URI = Uri.parse(Defs.MENTIONS_SCHEMA);
	private void extractUidFromUri() {
		Uri uri = getIntent().getData();
		if (uri !=null && PROFILE_URI.getScheme().equals(uri.getScheme())) {
			uid = uri.getQueryParameter(Defs.PARAM_UID);
			
	    }
		if(uid.indexOf("www") == 0){
			uid = "http://"+uid;
		}else if(uid.indexOf("https") == 0){
			String bUid = uid.substring(5, uid.length());
			uid = "http"+bUid;
			
		}
	}
}
