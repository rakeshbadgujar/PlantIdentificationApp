package com.example.wilidflower;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class Display extends AppCompatActivity{

     TextView description;
     ImageView iv;

    String[] sdata ={"Blue Curlsclose\n" +
            "Hydrophyllaceae - Waterleaf Family \n" +
            "Phacelia patulaeflora Engelm. & Gray.\n" +
            "\n" +
            "This small but attractive blue wildflower is found on sandy soils. As its common name suggests, the flower stalk uncurls as the flowers open. \n" +
            "Mar - Nov",
            "Drummond's Phloxclose\n" +
                    "Polemoniaceae - Phlox Family \n" +
                    "Phlox drummondii Hook.\n" +
                    "\n" +
                    "Phlox is common Texas wildflower. Some native populations have red flowers. These red forms are often included in commercial wildflower seed mixtures, though pink is much more common in the wild. In South Texas, in the deep sands near Sarita, we have a subspecies called Phlox drummondii subsp. glabriflora with trailing or reclining stems instead of the more upright and erect stems of the typical species. \n" +
                    "Feb - Jun",
            "Indian Blanketclose\n" +
                    "Asteraceae - Sunflower Family \n" +
                    "Gaillardia pulchella Foug.\n" +
                    "\n" +
                    "An annual or short lived perennial that may flower for a long period of time. Some Indian Blankets may lack the ray florets. \n" +
                    "Feb - Dec \n" +
                    "Like all members of the Sunflower Family, the Flower is actually a collection of many tiny flowers or florets. What looks like petals are florets with three of the corolla lobes fused into a single large petal or ray. They are called RAY FLORETS . The florets in the center have five tiny corolla lobes and are called DISK FLORETS.",
                    "Lantana, Calico Bushclose\n" +
                            "Verbenaceae - Verbena Family \n" +
                            "Lantana horrida H.B.K.\n" +
                            "\n" +
                            "This is the native Lantana, with a head of small flowers which open yellow and turn to orange and then red. The plant is a weak shrub and often is seen with its branches supported by other shrubbery. The foliage has a strong somewhat unpleasant odor when crushed or bruised. \n" +
                            "Feb - Dec",
                    "Meadow Pink, Texas Starclose\n" +
                            "Gentianaceae - Gentian Family \n" +
                            "Sabatia campestris Nutt.\n" +
                            "\n" +
                            "Annual with deep rose-pink flowers in damp sandy soils. A smaller flowered species Sabatia arenicola Greenm. Saltmarsh Pink occurs on the islands and the coast. \n" +
                            "Feb - Jun",
                    "Nipple Cactusclose\n" +
                            "Cactaceae - Cactus Family \n" +
                            "Mammillaria gummifera Engelm.\n" +
                            "\n" +
                            "Common low growing cactus on various soils in South Texas, with pale pink or creamy petals and red fruit. The needles of the cactus family are actually modified leaves. This special leaf economizes water loss, allowing the cactus flourish in its naturally dry habitat. \n" +
                            "Feb - Apri",
                    " Prickly Poppyclose\n" +
                            "Papaveraceae - Poppy Family \n" +
                            "Argemone sanguinea Greene.\n" +
                            "\n" +
                            "As the common name reflects this plants gray green foliage and stems are covered in prickles. While white is the most common, lavender and purple petal forms are also present in South Texas and may be found intermixed. A yellow flowered species Argemone mexicana L., which is native to the West Indies is also seen sometimes in South Texas. The yellow latex that oozes from cut or broken leaves and stems may irritate the skin of sensitive individuals (though the prickles probably would have gotten you already!) \n" +
                            "Feb - Jun (Dec)",
                    "Globe Mallowclose\n" +
                            "Malvaceae - Mallow Family \n" +
                            "Sphaeralcea lindheimeri Gray.\n" +
                            "\n" +
                            "The leaves of this species have thick velvety hairs. It is a common plant in deep sands both inland and along the coast. Like its relative Hibiscus, the stamens of the flower are fused into tube surrounding the female parts of the flower. \n" +
                            "Feb - May (Dec)",
                     "Spiderwortclose\n" +
                             "Commelinaceae - Spiderwort Family \n" +
                             "Tradescantia hirsutiflora Bush.\n" +
                             "\n" +
                             "Low growing perennial with three petals, occurring in a variety of shades of blue, rose and purple. \n" +
                             "Feb - May"

    };

    Integer[] simage={
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
        setContentView(R.layout.display);

        description = (TextView) findViewById(R.id.image_description);

        int s=getIntent().getIntExtra("s1",-1);

        iv = (ImageView) findViewById(R.id.image_view);

        Picasso.with(this).load(simage[s]).into(iv);

        description.setText(sdata[s]);
    }
}