package com.example.wilidflower;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity{

    ListView list;
    SearchView searchView;
    CustomListAdapter adapter;
    List<Flower> flowerList;

    String[] itemname ={
        "Blue Curl Flower",
        "Drummond Phlox",
        "Indian Blanket",
        "Lantana",
        "Meadow Pink",
        "Nipple Cactus",
        "Prickle",
        "Sphaera Ice Acoccinea",
        "Spider Wort"
    };

    String[] itemdescription ={
        "Blue Curl Flower Description",
        "Drummond Phlox Description",
        "Indian Blanket Description",
        "Lantana Description",
        "Meadow Pink Description",
        "Nipple Cactus Description",
        "Prickle Description",
        "Sphaera Ice Acoccinea Description",
        "Spider Wort Description"
    };

    Integer[] imgid={
            R.drawable.bluecurlsflowers,
            R.drawable.drummondphlox,
            R.drawable.indianblanket,
            R.drawable.lantana,
            R.drawable.meadowpink,
            R.drawable.nipplecactus,
            R.drawable.prickle,
            R.drawable.sphaeralceacoccinea,
            R.drawable.spiderwort
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flowerList = new ArrayList<Flower>();
        for(int i=0;i<itemname.length;i++) {
            flowerList.add(new Flower(itemname[i],itemdescription[i],imgid[i]));
        }


        adapter=new CustomListAdapter(this, flowerList);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
                String Slecteditem= itemname[+position];
                Toast.makeText(getApplicationContext(), Slecteditem, Toast.LENGTH_SHORT).show();

                Intent i= new Intent(getApplicationContext(),Display.class );
                i.putExtra("s1",position);
                startActivity(i);
            }
        });

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater mi = getMenuInflater();
        mi.inflate(R.menu.main_menu, menu);

        MenuItem myActionMenuItem = menu.findItem(R.id.menu_search);
        searchView = (SearchView) myActionMenuItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                MainActivity.this.adapter.getFilter().filter(query);
                return true;
            }
        });

        return true;

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

        }
        return super.onOptionsItemSelected(item);
    }

}