package com.example.sustainabilityapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private final SelectListener listener;
    private final List<ProductItem> productItems;
    private final Context context;


    public ProductAdapter(Context context, SelectListener listener,List<ProductItem> productItems){
        this.productItems =productItems;
        this.listener=listener;
        this.context = context;
    }
    @NonNull
    @Override
    public ProductAdapter.ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.product_item,parent,false);
        return new ProductAdapter.ProductViewHolder(view,listener);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ProductViewHolder holder, int position) {

        holder.productImage.setImageResource(productItems.get(position).getImage());
        holder.productBrand.setText(productItems.get(position).getBrand());
        holder.productName.setText(productItems.get(position).getName());
        holder.productPrice.setText(productItems.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return productItems.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder{

        public ImageView productImage;
        public TextView productName,productPrice,productBrand;

        public ProductViewHolder(@NonNull View itemView, SelectListener listener) {
            super(itemView);
            productImage=itemView.findViewById(R.id.product_image);
            productName=itemView.findViewById(R.id.product_name);
            productPrice=itemView.findViewById(R.id.product_price);
            productBrand=itemView.findViewById(R.id.product_brand);

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
