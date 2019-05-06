package edr.bhanuinfosystems.com.Adapters;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;



import java.util.List;

import edr.bhanuinfosystems.com.Activities.Admin.doc_details;
import edr.bhanuinfosystems.com.R;
import edr.bhanuinfosystems.com.model.Doctor;

/**
 * Created by Belal on 10/18/2017.*/


public class reg_doc_list_adapter extends RecyclerView.Adapter<reg_doc_list_adapter.ProductViewHolder> {


    private Context mCtx;
    private List<Doctor> productList;

    public reg_doc_list_adapter(Context mCtx, List<Doctor> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view ;
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        view = inflater.inflate(R.layout.doc_list_reg,parent,false) ;
        final ProductViewHolder viewHolder = new ProductViewHolder(view) ;
        viewHolder.view_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(mCtx,doc_details.class);

                i.putExtra("id",productList.get(viewHolder.getAdapterPosition()).getId());
                i.putExtra("dname",productList.get(viewHolder.getAdapterPosition()).getDname());
                i.putExtra("dgen",productList.get(viewHolder.getAdapterPosition()).getDgen());
                i.putExtra("dmob",productList.get(viewHolder.getAdapterPosition()).getDmob());
                i.putExtra("demail",productList.get(viewHolder.getAdapterPosition()).getDemail());
                i.putExtra("dcity",productList.get(viewHolder.getAdapterPosition()).getDcity());
                i.putExtra("dspec",productList.get(viewHolder.getAdapterPosition()).getDspec());
                i.putExtra("dexp",productList.get(viewHolder.getAdapterPosition()).getDexp());
                i.putExtra("dreg",productList.get(viewHolder.getAdapterPosition()).getDreg());
                i.putExtra("status",productList.get(viewHolder.getAdapterPosition()).getStatus());
                mCtx.startActivity(i);

            }
        });




        return viewHolder;

       // LayoutInflater inflater = LayoutInflater.from(mCtx);
       // View view = inflater.inflate(R.layout.doc_list_reg, null);
       // return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        Doctor product = productList.get(position);


        holder.textViewPrice.setText(String.valueOf(product.getId()));
        holder.textViewTitle.setText(product.getDname());
        holder.textViewShortDesc.setText(product.getDgen());
        holder.textViewRating.setText(String.valueOf(product.getStatus()));

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle, textViewShortDesc, textViewRating, textViewPrice;
        ImageView imageView;
        LinearLayout view_container;

        public ProductViewHolder(View itemView) {
            super(itemView);

            view_container = itemView.findViewById(R.id.container);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewShortDesc = itemView.findViewById(R.id.textViewShortDesc);
            textViewRating = itemView.findViewById(R.id.textViewRating);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);
            imageView = itemView.findViewById(R.id.imageView);

        }
    }
}