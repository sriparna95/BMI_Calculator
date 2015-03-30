package com.mycompany.bmi9;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;




public class MainActivity4 extends Activity {

    EditText editTask;
    Button saveBtn;
    TinyDB tinydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity4);

        editTask = (EditText) findViewById(R.id.editText);
        saveBtn = (Button) findViewById(R.id.button);

        tinydb  = new TinyDB(getApplicationContext());
    }


    public void SaveTask(View view){
        String newTask = editTask.getText().toString();
//        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPref.edit();
//        editor.putString("Task", newTask);
//        editor.commit();
        tinydb.putString("Task", newTask);
    }

    public void getSavedTask(View view){
//        Context context = this;
//        SharedPreferences sharedPref = context.getSharedPreferences(getString(R.string.savedTasks), Context.MODE_PRIVATE);
//
//        String task2update = "No task found.";
//        task2update = sharedPref.getString("Task", task2update);
//        Toast.makeText(getApplicationContext(),task2update,Toast.LENGTH_SHORT).show();
        String task2Update = tinydb.getString("Task");
//      TODO:
//       if (task2Update == ""){
//           task2Update = "No tasks saved for this day.";
//       }
//       textView.setText(task2update);
//  Add feature for saving multiple tasks in a single date
//       date = day+"/"+month+"/"+year;
//         key = date+"Task"; // key = "26/03/2015Task"
//       tinydb.putString(key, editTextValue);
//
//        i = 0;
//        if(tinydb.getString(date+"Task"+i) == NULL)
//        key = date+"Task"+i
//        else i++; date+"Task"+i;

////        Status
//        key = date+"Done"
//        key = "26/03/2015Done"
//        String task2update = tinydb.getString(key);
//        key = date+"Done"+i == true => Task completed or == false => Task not done

        Toast.makeText(getApplicationContext(), task2Update, Toast.LENGTH_SHORT).show();
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}