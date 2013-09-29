package net.nfs.alandubs.updateactivity;

import android.R.string;
import android.os.Bundle;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
//import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends Activity {

	private BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {
		@Override
		public void onReceive(Context context, Intent intent){
			Bundle bundle = intent.getExtras();
			
			if(bundle != null){
				MainActivity.this.receivedBroadcast(intent, bundle);
			}
			else {
				Log.d("activity", "no bundle");
			}
			//don't pass if no extra data
		}
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);
	}
	
	@Override
	public void onResume(){
		super.onResume();
		IntentFilter filter = new IntentFilter();
		filter.addAction("net.nfs.alandubs.updateactivity.LAP_COMPLETE");
		this.registerReceiver(this.mBroadcastReceiver, filter);
	}
	
	@Override
	public void onPause(){
		super.onPause();
		this.unregisterReceiver(this.mBroadcastReceiver);
	}
	
	private void receivedBroadcast(Intent i, Bundle b){
		//string swimmer = (string) b.getInt("swimmer");
		Log.d("receiveBroadcast", "hi");
		Toast.makeText(this, " " + b.containsKey("swimmer"), Toast.LENGTH_SHORT).show();
	}



}
