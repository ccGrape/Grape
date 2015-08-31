package com.doubleC.grape.common.view;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
/**
 * 流式布局 
 * @author boubleC
 *
 */
public class FlowLayout extends ViewGroup{

	public FlowLayout(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public FlowLayout(Context context, AttributeSet attrs) {
		super(context, attrs,0);
	}

	public FlowLayout(Context context) {
		this(context,null);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		//match_parent的话测量的是屏幕的宽高
		//如果是固定的值的话就是固定的宽高
		int sizeWidth = MeasureSpec.getSize(widthMeasureSpec);//具体这是个什么，是屏幕的宽度吗?
		int modelWidth = MeasureSpec.getMode(widthMeasureSpec);
		
		int sizeHeight = MeasureSpec.getSize(heightMeasureSpec);
		int modelHeight = MeasureSpec.getMode(heightMeasureSpec);
		
		//wrap_content
		int width = 0;
		int height = 0;
		
		//每一行的宽高
		int lineWidht = 0;
		int lineHeight = 0;
		
		int cCount = getChildCount();
		for(int i=0;i<cCount;i++){
			View child = getChildAt(i);
			//测量子view的宽高
			measureChild(child, widthMeasureSpec, heightMeasureSpec);
			//得到子view的params
			MarginLayoutParams lp = (MarginLayoutParams) child.getLayoutParams();
			int childWidth = child.getMeasuredWidth()+lp.leftMargin+lp.rightMargin;
			int childHeight = child.getMeasuredHeight()+lp.topMargin+lp.bottomMargin;
			if(lineWidht+childWidth>sizeWidth-getPaddingLeft()-getPaddingRight()){
				width = Math.max(width, lineWidht);
				lineWidht = childWidth;
				height+=lineHeight;
				lineHeight = childHeight;
			}else{
				lineWidht+=childWidth;
				lineHeight = Math.max(lineHeight, childHeight);
			}
			
			if(i==cCount-1){
				width = Math.max(lineWidht, width);
				height+=lineHeight;
			}
		}
		
		Log.d("fcc", "sizeWidth"+sizeWidth);
		Log.d("fcc", "sizeHeight"+sizeHeight);
		
		setMeasuredDimension(
				modelWidth==MeasureSpec.EXACTLY?sizeWidth:width+getPaddingLeft()+getPaddingRight(),
				modelHeight==MeasureSpec.EXACTLY?sizeHeight:height+getPaddingBottom()+getPaddingTop()	
				);
	}
	
	
	//保存每一行的所有的view 
	private List<List<View>> mAllView = new ArrayList<List<View>>();
	//存储所有行高
	private List<Integer> mLineHeight = new ArrayList<Integer>();
	
	@Override
	protected void onLayout(boolean arg0, int l, int t, int r, int b) {
		mAllView.clear();
		mLineHeight.clear();
		//当前viewGroup 的宽度
		int width = getWidth();
		
		int lineWidht = 0;
		int lineHeight = 0;
		
		List<View> lineViews = new ArrayList<View>();
		int cCount = getChildCount();
		for(int i=0;i<cCount;i++){
			View child = getChildAt(i);
			MarginLayoutParams lp = (MarginLayoutParams) child.getLayoutParams();
			
			int childWidth = child.getMeasuredWidth();
			int childHeight = child.getMeasuredHeight();
			
			if(childWidth+lineWidht+lp.leftMargin+lp.rightMargin>width-getPaddingLeft()-getPaddingRight()){
				//记录行高
				mLineHeight.add(lineHeight);
				//记录当前行所有的view 
				mAllView.add(lineViews);
				
				//重置行的宽高
				lineWidht = 0;
				lineHeight = childHeight+lp.topMargin+lp.bottomMargin;
				
				lineViews = new ArrayList<View>();
			}
			
			lineWidht+=childWidth+lp.leftMargin+lp.rightMargin;
			lineHeight = Math.max(childHeight+lp.topMargin+lp.bottomMargin, lineHeight);
			lineViews.add(child);
		}//for end
		
		//处理最后一行
		mLineHeight.add(lineHeight);
		mAllView.add(lineViews);
		
		//设置子view 的位置
		
		int left = getPaddingLeft();
		int top = getPaddingTop();
		
		int lineNum = mAllView.size();
		for(int i=0;i<lineNum;i++){
			//得到一行的所有的view 
			lineViews = mAllView.get(i);
			lineHeight = mLineHeight.get(i);
			for(int j = 0;j<lineViews.size();j++){
				View child = lineViews.get(j);
				if(child.getVisibility() == View.GONE){
					continue;
				}
				
				MarginLayoutParams lp = (MarginLayoutParams) child.getLayoutParams();
				int lc = left+lp.leftMargin;
				int tc = top+lp.topMargin;
				int rc = lc+child.getMeasuredWidth();
				int bc = top + child.getMeasuredHeight();
				
				child.layout(lc, tc, rc, bc);
				
				left+=child.getMeasuredWidth()+lp.leftMargin+lp.rightMargin;
			}//for j end
			left = getPaddingLeft();
			top+=lineHeight;
			
		}
	}
	
	@Override
	public LayoutParams generateLayoutParams(AttributeSet attrs) {
		return new MarginLayoutParams(getContext(), attrs);
	}
}
