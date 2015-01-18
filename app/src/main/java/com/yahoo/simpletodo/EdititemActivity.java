package com.yahoo.simpletodo;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class EdititemActivity extends ActionBarActivity {

    EditText etNewItemContent;
    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edititem);
        String curContent = getIntent().getStringExtra("cur_content");
        pos = getIntent().getIntExtra("pos", 0);
        etNewItemContent = (EditText) findViewById(R.id.etNewItemContent);
        etNewItemContent.setText(curContent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_edititem, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onSaveEdit(View v) {
        String editedContent = etNewItemContent.getText().toString();
        Intent data = getIntent();
        data.putExtra("editedContent", editedContent);
        data.putExtra("pos", pos);
        setResult(RESULT_OK, data);
        finish();
    }
}
