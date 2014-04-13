package com.example.hackathongame;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
import android.content.Intent;

import java.util.Random;

public class EncounterScreen extends Activity {
	
    TextView adjective1 = (TextView) findViewById(R.id.encounter_creature_adj1);
    TextView adjective2 = (TextView) findViewById(R.id.encounter_creature_adj2);
    TextView rarityView = (TextView) findViewById(R.id.encounter_rarity_display);
    TextView hpView = (TextView) findViewById(R.id.encounter_hp_display);
    TextView adView = (TextView) findViewById(R.id.encounter_ad_display);
    TextView defView = (TextView) findViewById(R.id.encounter_def_display);
    TextView name = (TextView) findViewById(R.id.encounter_creature_type);
    
    Button reroll = (Button) findViewById(R.id.encounter_debug);
    Button fite = (Button) findViewById(R.id.encounter_fight);
    Button run = (Button) findViewById(R.id.encounter_fight);
    
    Random rand = new Random();
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_screen);
        
        reroll.setOnClickListener(rerollListener);
        fite.setOnClickListener(fightListener);
        run.setOnClickListener(runListener);
        
        generateAndDisplayName();
        generateAndDisplayStats();
    }
	private OnClickListener rerollListener = new OnClickListener(){
		public void onClick(View v){
			generateAndDisplayName();
			generateAndDisplayStats();
		}
	};
	private OnClickListener fightListener = new OnClickListener(){
		public void onClick(View v){
				Intent loggedIn = new Intent(getBaseContext(), MapScreen.class); //TODO: Change MapScreen.class to FightScreen.class
				loggedIn.putExtra("rarity", rarityView.getText().toString());
				loggedIn.putExtra("hp", hpView.getText().toString());
				loggedIn.putExtra("ad", adView.getText().toString());
				loggedIn.putExtra("def", defView.getText().toString());
				startActivity(loggedIn); //TODO: Change to fitescreen
		}
	};
	private OnClickListener runListener = new OnClickListener(){
		public void onClick(View v){
			Toast.makeText(getApplicationContext(), "!!There is no escape!!", Toast.LENGTH_LONG).show();
		}
	};
	
    private void generateAndDisplayName(){
        adjective1.setText(Generator.generateAdj());
        adjective2.setText(Generator.generateAdj());
        name.setText(Generator.generateName());
    }
    private void generateAndDisplayStats(){
    	int rarity = generateRarity();
    	switch(rarity){
			case 1: 
				hpView.setText("30");
				adView.setText("5");
				defView.setText("1");
				rarityView.setText("Pleb Tier");
				break;
			case 2:
				hpView.setText("60");
				adView.setText("10");
				defView.setText("2");
				rarityView.setText("Uncommon");
				break;
			case 3:
				hpView.setText("90");
				adView.setText("15");
				defView.setText("3");
				rarityView.setText("RARE");
				break;
			case 4:
				hpView.setText("120");
				adView.setText("25");
				defView.setText("4");
				rarityView.setText("BESTEST");
				break;
			default:
				hpView.setText("ERROR");
    	}
    }
    private int generateRarity(){
    	int seed = rand.nextInt(5) + 1;
    	return seed;
    }
    
}
