package com.doubleC.grape.business.find.urlregex;

import java.util.regex.Pattern;

import android.app.Activity;
import android.os.Bundle;
import android.text.util.Linkify;
import android.widget.TextView;

import com.doubleC.grape.R;

public class UrlRegexActivity extends Activity {

	private TextView url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.urlregex);
        url = (TextView) findViewById(R.id.url);
        String str = "@aman_vivekhowareu,#aman_vivekwww.baidu.com,http://www.baidu.com;hhh.kk。https://www.sohu.com sdfdf";
        url.setText(str);
		extractUrl2Link(url);
    }

    private void extractUrl2Link(TextView v) {
		Pattern wikiWordMatcher = Pattern.compile("(((http\\:\\/\\/)|(https\\:\\/\\/)|(www\\.))[a-zA-Z0-9_\\.]+)");
		String mentionsScheme = String.format("%s/?%s=", Defs.MENTIONS_SCHEMA, Defs.PARAM_UID);
		Linkify.addLinks(v, wikiWordMatcher,mentionsScheme);
	} 
    
}
