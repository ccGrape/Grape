package com.doubleC.grape.common.util;

import java.util.regex.Pattern;

import android.content.Context;
import android.text.Spannable;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.UnderlineSpan;
import android.text.util.Linkify;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * 超链接TextView（去除下划线的）
 * @author 141654
 *
 */
public class LinkTextView extends TextView {

    public LinkTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
    }

    public LinkTextView(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
    }

    private class NoUnderlineSpan extends UnderlineSpan {  
        
        @Override  
        public void updateDrawState(TextPaint ds) {  
            ds.setUnderlineText(false);  
        }  
    }

    @Override
    public void setText(CharSequence text, BufferType type) {
        super.setText(text, type);
        
        this.setAutoLinkMask(Linkify.WEB_URLS);
        if (this.getText() instanceof Spannable) {  
            Spannable s = (Spannable) this.getText();
            s.setSpan(new NoUnderlineSpan(), 0, s.length(), Spanned.SPAN_MARK_MARK);  
        }
    }

    /**
     * url正则匹配
     */
    public void urlRegEx(){
        String urlRegEx = "^(http|www|ftp|)?(://)?(\\w+(-\\w+)*)(\\.(\\w+(-\\w+)*))*((:\\d+)?)(/(\\w+(-\\w+)*))*(\\.?(\\w)*)(\\?)?(((\\w*%)*(\\w*\\?)*(\\w*:)*(\\w*\\+)*(\\w*\\.)*(\\w*&)*(\\w*-)*(\\w*=)*(\\w*%)*(\\w*\\?)*(\\w*:)*(\\w*\\+)*(\\w*\\.)*(\\w*&)*(\\w*-)*(\\w*=)*)*(\\w*)*)$";
        int flags = Pattern.CASE_INSENSITIVE;
        Pattern p = Pattern.compile(urlRegEx, flags);
        Linkify.addLinks(LinkTextView.this, p,"");
    }
}
