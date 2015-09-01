package com.doubleC.grape.business.find.dialog;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.doubleC.grape.R;
import com.doubleC.grape.common.view.ActionSheetDialog;
import com.doubleC.grape.common.view.ActionSheetDialog.OnSheetItemClickListener;
import com.doubleC.grape.common.view.ActionSheetDialog.SheetItemColor;
import com.doubleC.grape.common.view.AlertDialog;

public class DialogActivity extends Activity implements OnClickListener {
	private Button btn1;
	private Button btn2;
	private Button btn3;
	private Button btn4;
	private Button btn5;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
	}

	private void initView() {
		btn1 = (Button) findViewById(R.id.btn1);
		btn1.setOnClickListener(this);
		btn2 = (Button) findViewById(R.id.btn2);
		btn2.setOnClickListener(this);
		btn3 = (Button) findViewById(R.id.btn3);
		btn3.setOnClickListener(this);
		btn4 = (Button) findViewById(R.id.btn4);
		btn4.setOnClickListener(this);
		btn5 = (Button) findViewById(R.id.btn5);
		btn5.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn1:
			new ActionSheetDialog(DialogActivity.this)
					.builder()
					.setTitle("btn1")
					.setCancelable(false)
					.setCanceledOnTouchOutside(false)
					.addSheetItem("btn1", SheetItemColor.Red,
							new OnSheetItemClickListener() {
								@Override
								public void onClick(int which) {

								}
							}).show();
			break;
		case R.id.btn2:
			new ActionSheetDialog(DialogActivity.this)
					.builder()
					.setCancelable(false)
					.setCanceledOnTouchOutside(false)
					.addSheetItem("btn1", SheetItemColor.Blue,
							new OnSheetItemClickListener() {
								@Override
								public void onClick(int which) {

								}
							})
					.addSheetItem("btn2", SheetItemColor.Blue,
							new OnSheetItemClickListener() {
								@Override
								public void onClick(int which) {

								}
							})
					.addSheetItem("btn3", SheetItemColor.Blue,
							new OnSheetItemClickListener() {
								@Override
								public void onClick(int which) {

								}
							})
					.addSheetItem("btn4", SheetItemColor.Blue,
							new OnSheetItemClickListener() {
								@Override
								public void onClick(int which) {

								}
							})
					.addSheetItem("btn5", SheetItemColor.Blue,
							new OnSheetItemClickListener() {
								@Override
								public void onClick(int which) {

								}
							})
					.addSheetItem("btn6", SheetItemColor.Blue,
							new OnSheetItemClickListener() {
								@Override
								public void onClick(int which) {

								}
							}).show();
			break;
		case R.id.btn3:
			new ActionSheetDialog(DialogActivity.this)
					.builder()
					.setTitle("btn3")
					.setCancelable(false)
					.setCanceledOnTouchOutside(false)
					.addSheetItem("dddddd", SheetItemColor.Blue,
							new OnSheetItemClickListener() {
								@Override
								public void onClick(int which) {
									Toast.makeText(DialogActivity.this,
											"item" + which, Toast.LENGTH_SHORT)
											.show();
								}
							})
					.addSheetItem("dddddd", SheetItemColor.Blue,
							new OnSheetItemClickListener() {
								@Override
								public void onClick(int which) {
									Toast.makeText(DialogActivity.this,
											"item" + which, Toast.LENGTH_SHORT)
											.show();
								}
							})
					.addSheetItem("dddddd", SheetItemColor.Blue,
							new OnSheetItemClickListener() {
								@Override
								public void onClick(int which) {
									Toast.makeText(DialogActivity.this,
											"item" + which, Toast.LENGTH_SHORT)
											.show();
								}
							})
					.addSheetItem("dddddd", SheetItemColor.Blue,
							new OnSheetItemClickListener() {
								@Override
								public void onClick(int which) {
									Toast.makeText(DialogActivity.this,
											"item" + which, Toast.LENGTH_SHORT)
											.show();
								}
							})
					.addSheetItem("dddddd", SheetItemColor.Blue,
							new OnSheetItemClickListener() {
								@Override
								public void onClick(int which) {
									Toast.makeText(DialogActivity.this,
											"item" + which, Toast.LENGTH_SHORT)
											.show();
								}
							})
					.addSheetItem("dddddd", SheetItemColor.Blue,
							new OnSheetItemClickListener() {
								@Override
								public void onClick(int which) {
									Toast.makeText(DialogActivity.this,
											"item" + which, Toast.LENGTH_SHORT)
											.show();
								}
							})
					.addSheetItem("dddddd", SheetItemColor.Blue,
							new OnSheetItemClickListener() {
								@Override
								public void onClick(int which) {
									Toast.makeText(DialogActivity.this,
											"item" + which, Toast.LENGTH_SHORT)
											.show();
								}
							})
					.addSheetItem("dddddd", SheetItemColor.Blue,
							new OnSheetItemClickListener() {
								@Override
								public void onClick(int which) {
									Toast.makeText(DialogActivity.this,
											"item" + which, Toast.LENGTH_SHORT)
											.show();
								}
							})
					.addSheetItem("dddddd", SheetItemColor.Blue,
							new OnSheetItemClickListener() {
								@Override
								public void onClick(int which) {
									Toast.makeText(DialogActivity.this,
											"item" + which, Toast.LENGTH_SHORT)
											.show();
								}
							})
					.addSheetItem("dddddd", SheetItemColor.Blue,
							new OnSheetItemClickListener() {
								@Override
								public void onClick(int which) {
									Toast.makeText(DialogActivity.this,
											"item" + which, Toast.LENGTH_SHORT)
											.show();
								}
							}).show();
			break;
		case R.id.btn4:
			new AlertDialog(this).builder().setTitle("btn4")
					.setMsg("这里是内容")
					.setPositiveButton("地对地导弹", new OnClickListener() {
						@Override
						public void onClick(View v) {

						}
					}).setNegativeButton("很好看好", new OnClickListener() {
						@Override
						public void onClick(View v) {

						}
					}).show();
			break;
		case R.id.btn5:
			new AlertDialog(this).builder()
					.setMsg("或电话发货的合法化")
					.setNegativeButton("确定", new OnClickListener() {
						@Override
						public void onClick(View v) {

						}
					}).show();
			break;
		default:
			break;
		}
	}
}
