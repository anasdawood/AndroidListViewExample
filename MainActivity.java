package com.mater.binane;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.example.adapter.PickupNotificationAdapter;
import com.example.model.PickupNotification;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private final String FIREBASE_COLLECTION_PATH = "path";
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference(FIREBASE_COLLECTION_PATH);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        final ListView messageListView = findViewById(R.id.messages_list);
        Query allRequestsFromUser = myRef.orderByChild("child_name").equalTo(user.getUid());
        allRequestsFromUser.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ArrayList<MessageEntry> messages = new ArrayList<>();
                for(DataSnapshot request : snapshot.getChildren() ){
                    MessageEntry message = request.getValue(MessageEntry.class);
                    messages.add(message);
                }
                PickupNotificationAdapter arrayAdapter
                        = new PickupNotificationAdapter(MainActivity.this, messages);

                messageListView.setAdapter(arrayAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}
