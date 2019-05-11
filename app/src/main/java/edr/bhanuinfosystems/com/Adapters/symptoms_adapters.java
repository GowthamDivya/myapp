package edr.bhanuinfosystems.com.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import java.util.List;

import edr.bhanuinfosystems.com.R;
import edr.bhanuinfosystems.com.model.Complaint;
import edr.bhanuinfosystems.com.model.Symptom;

public class symptoms_adapters extends RecyclerView.Adapter<symptoms_adapters.ProductViewHolder> {


    private Context mCtx;
    private List<Symptom> productList;

    public symptoms_adapters(Context mCtx, List<Symptom> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view ;
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        view = inflater.inflate(R.layout.symptom_item_list,parent,false) ;
        final ProductViewHolder viewHolder = new ProductViewHolder(view) ;
        viewHolder.view_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });




        return viewHolder;

        // LayoutInflater inflater = LayoutInflater.from(mCtx);
        // View view = inflater.inflate(R.layout.doc_list_reg, null);
        // return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        Symptom product = productList.get(position);



        holder.compname.setText(product.getSname());



    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder {

        CheckBox compname;

        LinearLayout view_container;

        public ProductViewHolder(View itemView) {
            super(itemView);

            view_container = itemView.findViewById(R.id.container3);
            compname = itemView.findViewById(R.id.symptom_name);

        }
    }
}