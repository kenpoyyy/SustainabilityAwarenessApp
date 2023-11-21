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

    private final SelectListener listener;
    private final List<EventItem> eventList;
    private final Context context;

    public EventAdapter(List<EventItem> eventList, Context context, SelectListener listener) {
        this.eventList = eventList;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.events_item, parent, false);

        return new EventAdapter.EventViewHolder(view, listener);
    }


    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.eventNumber.setText(eventList.get(position).getEventNumber());
        holder.eventType.setText(eventList.get(position).getEventType());
        holder.eventDescription.setText(eventList.get(position).getEventDescription());


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

        public EventViewHolder(@NonNull View itemView, SelectListener listener) {
            super(itemView);
            eventNumber = itemView.findViewById(R.id.tvNumber);
            eventType = itemView.findViewById(R.id.tvNumbersInText);
            eventDescription = itemView.findViewById(R.id.tvNumbersInText1);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null) {
                        int pos = getAdapterPosition();
                        if (pos != RecyclerView.NO_POSITION) {

                            // Animate the item when clicked
                            itemView.animate()
                                    .scaleX(0.95f)
                                    .scaleY(0.95f)
                                    .setDuration(150)
                                    .withEndAction(new Runnable() {
                                        @Override
                                        public void run() {
                                            itemView.animate()
                                                    .scaleX(1.0f)
                                                    .scaleY(1.0f)
                                                    .setDuration(150)
                                                    .start();
                                            // Handle the click event
                                            listener.onItemClicked(pos);
                                        }
                                    })
                                    .start();
                        }
                    }
                }
            });
        }
    }

}
