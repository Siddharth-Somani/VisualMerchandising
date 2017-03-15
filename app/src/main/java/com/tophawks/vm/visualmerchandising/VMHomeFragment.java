package com.tophawks.vm.visualmerchandising;


import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.tophawks.vm.visualmerchandising.adapter.SearchViewRecyclerAdapter;
import com.tophawks.vm.visualmerchandising.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;


/**
 * A simple {@link Fragment} subclass.
 */
public class VMHomeFragment extends Fragment {

    SliderLayout sliderLayout;
    StorageReference storageReference;
    DatabaseReference databaseReference;
    RecyclerView popularRV;
    ArrayList<Product> productArrayList;
    SearchViewRecyclerAdapter adapter;

    public VMHomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_vmhome, container, false);
        sliderLayout=(SliderLayout)v.findViewById(R.id.vm_home_image_slider);
        popularRV=(RecyclerView)v.findViewById(R.id.vm_home_rv);
        productArrayList=new ArrayList<>();
        //for slider view
        popularStoriesDownload();
        //for recycler view
        popularProductsDownload();

        return v;
    }

    private void popularProductsDownload() {
        databaseReference=FirebaseDatabase.getInstance().getReference();

        Query query=databaseReference.child("Product").orderByChild("originalPrice").limitToFirst(3);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot product:dataSnapshot.getChildren()) {
                    HashMap<String,Object> map=(HashMap<String, Object>)product.getValue();

                   productArrayList.add(new Product(
                         product.getKey()
                           ,(String)map.get("productName")
                           ,(String)map.get("productColor")
                           ,(String)map.get("productSpecification")
                           ,(String)map.get("imageUrl")
                           ,Float.parseFloat(map.get("wholeSalePrice").toString())
                           ,Float.parseFloat(map.get("retailPrice").toString())
                           ,Float.parseFloat(map.get("originalPrice").toString())
                           ,Float.parseFloat(map.get("discountPrice").toString())
                           , Integer.parseInt(map.get("productQuantity").toString())));
                }

                RecyclerView.LayoutManager manager=new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
                popularRV.setLayoutManager(manager);
                popularRV.hasFixedSize();
                adapter=new SearchViewRecyclerAdapter(getActivity(),productArrayList);
                popularRV.setAdapter(adapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    private void popularStoriesDownload() {
        storageReference= FirebaseStorage.getInstance().getReference().child("PopularStories");
        for(int i=1;i<6;i++)
        {
            final int fi=i;
            storageReference.child("popular_story_"+fi+".jpg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                @Override
                public void onSuccess(Uri uri) {
                    TextSliderView textSliderView=new TextSliderView(getActivity());
                    textSliderView
                            .description("popular_story_"+fi)
                            .image(uri.toString())
                            .setScaleType(BaseSliderView.ScaleType.CenterInside)
                            .setOnSliderClickListener((BaseSliderView.OnSliderClickListener) getActivity());
                    sliderLayout.addSlider(textSliderView);
                }

            });
        }
        sliderLayout.setPresetTransformer(SliderLayout.Transformer.RotateDown);
        sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        sliderLayout.setCustomAnimation(new DescriptionAnimation());
        sliderLayout.setDuration(2000);


    }


}
