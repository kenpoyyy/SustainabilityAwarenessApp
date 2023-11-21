package com.example.sustainabilityapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder> {

    private List<EventItem> eventList;
    private Context context;
    private final SelectListener listener;

    public EventAdapter(List<EventItem> eventList,Context context,SelectListener listener) {
        this.eventList = eventList;
        this.context=context;
        this.listener=listener;
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       LayoutInflater inflater=LayoutInflater.from(context);
       View view=inflater.inflate(R.layout.events_item,parent,false);

        return new EventAdapter.EventViewHolder(view,listener);
    }


    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.eventNumber.setText(eventList.get(position).getEventNumber());
        holder.eventType.setText(eventList.get(position).getEventType());
        holder.eventDescription.setText(eventList.get(position).getEventDescription());
        holder.viewDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClicked(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }


    public static class EventViewHolder extends RecyclerView.ViewHolder {
        //ImageView imageView;
        public TextView eventNumber;
        public TextView eventType;
        public TextView eventDescription;
        public Button viewDetails;
        public EventViewHolder(@NonNull View itemView,SelectListener listener){
            super(itemView);
            eventNumber = itemView.findViewById(R.id.tvNumber);
            eventType = itemView.findViewById(R.id.tvNumbersInText);
            eventDescription = itemView.findViewById(R.id.tvNumbersInText1);
            viewDetails = itemView.findViewById(R.id.viewDetailsButton);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(listener!=null){
                        int pos=getAdapterPosition();
                        if(pos!=RecyclerView.NO_POSITION){
                            listener.onItemClicked(pos);
                        }
                    }
                }
            });
        }

}

}