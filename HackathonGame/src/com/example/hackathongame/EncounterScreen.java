package com.example.hackathongame;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
import android.content.Intent;

import java.util.Random;

public class EncounterScreen extends Activity {
	TextView adjective1, adjective2, rarityView, hpView, adView, defView, name;
    Random rand;
    ImageView image;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encounter_screen);
        
        Button reroll = (Button) findViewById(R.id.encounter_debug);
        Button fite = (Button) findViewById(R.id.encounter_fight);
        Button run = (Button) findViewById(R.id.encounter__run);
        
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
				Intent win = new Intent(getBaseContext(), MapScreen.class); //TODO: Change MapScreen.class to FightScreen.class
				Intent lose = new Intent(getBaseContext(), MapScreen.class);
				win.putExtra("rarity", rarityView.getText().toString());
				win.putExtra("hp", hpView.getText().toString());
				win.putExtra("ad", adView.getText().toString());
				win.putExtra("def", defView.getText().toString());
				win.putExtra("adj1", adjective1.getText().toString());
				win.putExtra("adj2", adjective2.getText().toString());
				win.putExtra("name", name.getText().toString());

				lose.putExtra("rarity", rarityView.getText().toString());
				lose.putExtra("hp", hpView.getText().toString());
				lose.putExtra("ad", adView.getText().toString());
				lose.putExtra("def", defView.getText().toString());
				lose.putExtra("adj1", adjective1.getText().toString());
				lose.putExtra("adj2", adjective2.getText().toString());
				lose.putExtra("name", name.getText().toString());
				
				rand = new Random();
				if(rand.nextInt(1) == 1){
					startActivity(win); //TODO: Change to fitescreen
				}
				else{
					startActivity(lose); //TODO: Change to fitescreen
				}
		}
	};
	private OnClickListener runListener = new OnClickListener(){
		public void onClick(View v){
			Toast.makeText(getApplicationContext(), "!!There is no escape!!", Toast.LENGTH_LONG).show();
		}
	};
	
    private void generateAndDisplayName(){
    	adjective1 = (TextView) findViewById(R.id.encounter_creature_adj1);
        adjective2 = (TextView) findViewById(R.id.encounter_creature_adj2);
        rarityView = (TextView) findViewById(R.id.encounter_rarity_display);
        hpView = (TextView) findViewById(R.id.encounter_hp_display);
        adView = (TextView) findViewById(R.id.encounter_ad_display);
        defView = (TextView) findViewById(R.id.encounter_def_display);
        name = (TextView) findViewById(R.id.encounter_creature_type);
        image = (ImageView) findViewById(R.id.imageView1);
        
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
				image.setImageResource(R.drawable.creature1);
				break;
			case 2:
				hpView.setText("60");
				adView.setText("10");
				defView.setText("2");
				rarityView.setText("Uncommon");
				image.setImageResource(R.drawable.creature2);
				break;
			case 3:
				hpView.setText("90");
				adView.setText("15");
				defView.setText("3");
				rarityView.setText("RARE");
				image.setImageResource(R.drawable.creature3);
				break;
			case 4:
				hpView.setText("120");
				adView.setText("25");
				defView.setText("4");
				rarityView.setText("BESTEST");
				image.setImageResource(R.drawable.creature4);
				break;
			default:
				hpView.setText("ERROR");
    	}
    }
    
    private int generateRarity(){
    	rand = new Random();
    	int seed = rand.nextInt(4) + 1;
    	return seed;
    }
    
}
