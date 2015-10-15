package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class LonelyTwitterActivity extends Activity {

	private static final String FILENAME = "file.sav";   //model
	private EditText bodyText;//model
	private ListView oldTweetsList;//model
    private ArrayAdapter<Tweet> adapter;//model
	private Button saveButton;
	private ArrayList<Tweet> tweets = new ArrayList<Tweet>();//model
    private LonelyTwitterActivity activity = this;

	public Button getSaveButton() {
		return saveButton;
	}

	public ArrayList<Tweet> getTweets() {
		return tweets;
	}

	public EditText getBodyText() {
		return bodyText;
	}

	public ListView getOldTweetsList() {
		return oldTweetsList;
	}

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);//model
		setContentView(R.layout.main);//view

		bodyText = (EditText) findViewById(R.id.body);//controller
		saveButton = (Button) findViewById(R.id.save);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);//controller

		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);//model
				String text = bodyText.getText().toString();//model
				tweets.add(new NormalTweet(text));//model
				saveInFile();//model
				adapter.notifyDataSetChanged(); //view
			}
		});

        oldTweetsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(activity, EditTweetActivity.class);
                startActivity(intent);
            }
        });
	}

	@Override
	protected void onStart() {
		super.onStart();//model
		adapter = new ArrayAdapter<Tweet>(this,
				R.layout.list_item, tweets);//model
		oldTweetsList.setAdapter(adapter);//controller
        adapter.notifyDataSetChanged();//view
	}

	private void loadFromFile() {
        ArrayList<Tweet> tweets = new ArrayList<Tweet>();//model
		try {
			FileInputStream fis = openFileInput(FILENAME);//model
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));//model
			Gson gson = new Gson();//model
			Type arrayListType = new TypeToken<ArrayList<Tweet>>() {}.getType();//model
			tweets =  gson.fromJson(in, arrayListType);//controller
            String line = in.readLine();//model
            while (line != null) {
                tweets.add(new NormalTweet(line));//model
                line = in.readLine();//controller
            }

		} catch (FileNotFoundException e) {
			tweets =  new ArrayList<Tweet>();//model
		} catch (IOException e) {
			throw new RuntimeException(e);//model
		}
	}
	
	private void saveInFile() {
		try {
			FileOutputStream fos = openFileOutput(FILENAME, 0);//model
            BufferedWriter out =  new BufferedWriter(new OutputStreamWriter(fos));//model
            Gson gson = new Gson();//model
            gson.toJson(tweets, out);//controller
            fos.flush();//model
            fos.close();//model
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);//model
		} catch (IOException e) {
            throw new RuntimeException(e);//model
        }
	}

    public void clearTweets(View view){
        tweets.clear();//model
        saveInFile();//model
        adapter.notifyDataSetChanged();//view
    }
}