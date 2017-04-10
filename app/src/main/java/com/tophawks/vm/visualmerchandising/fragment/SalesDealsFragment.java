//package com.tophawks.vm.visualmerchandising.fragment;
//
//
//import android.content.Context;
//import android.content.Intent;
//import android.os.Bundle;
//import android.support.design.widget.FloatingActionButton;
//import android.support.design.widget.NavigationView;
//import android.support.v4.app.Fragment;
//import android.support.v4.content.ContextCompat;
//import android.support.v4.widget.DrawerLayout;
//import android.support.v7.app.ActionBarDrawerToggle;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.Toolbar;
//import android.view.LayoutInflater;
//import android.view.Menu;
//import android.view.MenuInflater;
//import android.view.MenuItem;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ListView;
//import android.widget.Toast;
//
//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.ValueEventListener;
//import com.google.firebase.storage.StorageReference;
//import com.tophawks.vm.visualmerchandising.Modules.SalesManagement.AddDealActivity;
//import com.tophawks.vm.visualmerchandising.Modules.SalesManagement.SalesHomeActivity;
//import com.tophawks.vm.visualmerchandising.R;
//import com.tophawks.vm.visualmerchandising.adapter.DealsAdapter;
//import com.tophawks.vm.visualmerchandising.model.Deals;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * A simple {@link Fragment} subclass.
// */
//public class SalesDealsFragment extends Fragment {
//
//    private Context context;
//    private ListView listView;
//
//    private DatabaseReference dRef;
//    private DatabaseReference dealsRef;
//    private StorageReference sRef;
//
//    public SalesDealsFragment(Context c) {
//        this.context = c;
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        View vi = inflater.inflate(R.layout.fragment_sales_deals, container, false);
//        listView = (ListView) vi.findViewById(R.id.dealslist);
//
//        return vi;
//    }
//
//    @Override
//    public void onStart() {
//        super.onStart();
//        setupBackend();
//        dealsRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                SalesHomeActivity.dealsList.clear();
//                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
//                    Deals deal = snapshot.getValue(Deals.class);
//                    SalesHomeActivity.dealsList.add(deal);
//                }
//                DealsAdapter adapter = new DealsAdapter(getActivity());
//                listView.setAdapter(adapter);
//            }
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });
//    }
//
//    private void setupBackend(){
//        dRef = FirebaseDatabase.getInstance().getReference("Sales");
//        dealsRef = dRef.child("Deals");
//    }
//
//
//}
