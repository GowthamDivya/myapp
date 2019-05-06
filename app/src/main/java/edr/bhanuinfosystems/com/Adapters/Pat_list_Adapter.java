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

import edr.bhanuinfosystems.com.Activities.Admin.Admin_Home;
import edr.bhanuinfosystems.com.Activities.Admin.Registered_doc_list;
import edr.bhanuinfosystems.com.Activities.Admin.doc_details;
import edr.bhanuinfosystems.com.Activities.Examination.Add_Examination;
import edr.bhanuinfosystems.com.R;
import edr.bhanuinfosystems.com.model.Doctor;
import edr.bhanuinfosystems.com.model.Patient;

public class Pat_list_Adapter extends RecyclerView.Adapter<Pat_list_Adapter.ProductViewHolder> {


    private Context mCtx;
    private List<Patient> productList;

    public Pat_list_Adapter(Context mCtx, List<Patient> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view ;
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        view = inflater.inflate(R.layout.patlist_item,parent,false) ;
        final ProductViewHolder viewHolder = new ProductViewHolder(view) ;
        viewHolder.view_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent i = new Intent(mCtx, Add_Examination.class);
                i.putExtra("pid",productList.get(viewHolder.getAdapterPosition()).getId());
                i.putExtra("pname",productList.get(viewHolder.getAdapterPosition()).getPname());
                i.putExtra("pgen",productList.get(viewHolder.getAdapterPosition()).getPgen());
                i.putExtra("page",productList.get(viewHolder.getAdapterPosition()).getPage());
                i.putExtra("pmob",productList.get(viewHolder.getAdapterPosition()).getPmob());
                i.putExtra("pemail",productList.get(viewHolder.getAdapterPosition()).getPemail());
                i.putExtra("pcity",productList.get(viewHolder.getAdapterPosition()).getPcity());
                i.putExtra("pdid",productList.get(viewHolder.getAdapterPosition()).getDid());

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
        Patient product = productList.get(position);


        holder.textViewPrice.setText(String.valueOf(product.getId()));
        holder.textViewTitle.setText(product.getPname());
        holder.textViewShortDesc.setText(product.getPgen());
        holder.textViewRating.setText(String.valueOf(product.getPage()));

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

            view_container = itemView.findViewById(R.id.container1);
            textViewTitle = itemView.findViewById(R.id.patname);
            textViewShortDesc = itemView.findViewById(R.id.patgen);
            textViewRating = itemView.findViewById(R.id.patage);
            textViewPrice = itemView.findViewById(R.id.patmob);


        }
    }
}