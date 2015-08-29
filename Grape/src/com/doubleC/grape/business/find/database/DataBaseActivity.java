package com.doubleC.grape.business.find.database;

import java.util.ArrayList;
import java.util.List;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.doubleC.grape.R;
import com.doubleC.grape.base.BaseActivity;
import com.doubleC.grape.business.find.database.bean.GrapeDataBaseBean;
import com.doubleC.grape.business.find.database.daapter.DataBaseAdapter;
import com.doubleC.grape.common.ToastUtil;
import com.doubleC.grape.common.database.DataBaseHelper;
import com.doubleC.grape.common.util.NetWorkBroadcastReceiver;

/**
 * 数据库测试
 * @author 155256
 *
 */
public class DataBaseActivity extends BaseActivity implements OnClickListener,OnItemClickListener{
    private NetWorkBroadcastReceiver netWorkBroadcastReceiver;
    
    private EditText database_edit_name,database_edit_description;
    private ListView database_listView;
    private TextView database_test1_add,database_test1_update,database_test1_delete;
    
    private List<GrapeDataBaseBean> list;
    private DataBaseAdapter adapter;
    
    private DataBaseHelper db;
    private Cursor mCursor;
    
    private int position=-1;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.database_test1);
        initView();
        initData();
        addListener();
    }
    
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
    
    @Override
    protected void initView() {
        database_edit_name  = (EditText) findViewById(R.id.database_edit_name);
        database_edit_description = (EditText) findViewById(R.id.database_edit_description);
        
        database_test1_add = (TextView) findViewById(R.id.database_test1_add);
        database_test1_update = (TextView) findViewById(R.id.database_test1_update);
        database_test1_delete = (TextView) findViewById(R.id.database_test1_delete);
        
        database_listView = (ListView) findViewById(R.id.database_listView);
    }

    @Override
    protected void addListener() {
        database_test1_add.setOnClickListener(this);
        database_test1_update.setOnClickListener(this);
        database_test1_delete.setOnClickListener(this);
        
        database_listView.setOnItemClickListener(this);
    }

    @Override
    protected void initData() {
        netWorkBroadcastReceiver = new NetWorkBroadcastReceiver();
        list = new ArrayList<GrapeDataBaseBean>();
        adapter = new DataBaseAdapter(this, list);
        database_listView.setAdapter(adapter);
        
        db = new DataBaseHelper(this);
        mCursor = db.select();
        for(int i=0,size=mCursor.getCount();i<size;i++){
        	mCursor.moveToPosition(i);
            GrapeDataBaseBean bean = new GrapeDataBaseBean();
            bean.setId(mCursor.getInt(0));
            bean.setName(mCursor.getString(1));
            bean.setDescription(mCursor.getString(2));
            list.add(bean);
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
        case R.id.database_test1_add:
            add();
            break;
        case R.id.database_test1_update:
        	if(position<0){
        		ToastUtil.showToastShort(this, "选择要进行更新的元素");
        		return;
        	}
        	updateDataBase(position);
            break;
        case R.id.database_test1_delete:
            if(position<0){
                ToastUtil.showToastShort(this, "选择要进行更新的元素");
                return;
            }
            delete(position);
            break;
        default:
            break;
        }
    }
    
    @SuppressWarnings("deprecation")
    private void add(){
        String name = database_edit_name.getText().toString();
        String description = database_edit_description.getText().toString();
        if(name.equals("")||description.equals("")){
            return;
        }
        db.insert(name, description);
        
        database_edit_name.setText("");
        database_edit_description.setText("");
        mCursor = db.select();
        list.clear();
        for(int i=0,size=mCursor.getCount();i<size;i++){
        	mCursor.moveToPosition(i);
            GrapeDataBaseBean bean = new GrapeDataBaseBean();
            bean.setId(mCursor.getInt(0));
            bean.setName(mCursor.getString(1));
            bean.setDescription(mCursor.getString(2));
            list.add(bean);
        }
        adapter.notifyDataSetChanged();
    }
    
    private void updateDataBase(int position){
    	mCursor.moveToPosition(position);
    	position = -1;
    	int id = mCursor.getInt(0);
    	db.update(id, "樊超超", "努力，自信，狼性");
    	mCursor = db.select();
    	list.clear();
        for(int i=0,size=mCursor.getCount();i<size;i++){
        	mCursor.moveToPosition(i);
            GrapeDataBaseBean bean = new GrapeDataBaseBean();
            bean.setId(mCursor.getInt(0));
            bean.setName(mCursor.getString(1));
            bean.setDescription(mCursor.getString(2));
            list.add(bean);
        }
        adapter.notifyDataSetChanged();
    }

    private void delete(int po){
        mCursor.moveToPosition(po);
        position = -1;
        int id = mCursor.getInt(0);
        
        db.delete(id);
        mCursor = db.select();
        list.clear();
        for(int i=0,size=mCursor.getCount();i<size;i++){
            mCursor.moveToPosition(i);
            GrapeDataBaseBean bean = new GrapeDataBaseBean();
            bean.setId(mCursor.getInt(0));
            bean.setName(mCursor.getString(1));
            bean.setDescription(mCursor.getString(2));
            list.add(bean);
        }
        adapter.notifyDataSetChanged();
    }
    
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		position = arg2;
	}
}
