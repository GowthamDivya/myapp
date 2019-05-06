package edr.bhanuinfosystems.com.Adapters;



import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;



import java.util.List;

import edr.bhanuinfosystems.com.R;
import edr.bhanuinfosystems.com.model.Doctor;

/**
 * Created by Belal on 10/18/2017.
 */

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ProductViewHolder> {


    private Context mCtx;
    private List<Doctor> productList;

    public ProductsAdapter(Context mCtx, List<Doctor> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.clist_layout, null);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        Doctor product = productList.get(position);

        //loading the image

        holder.textViewTitle.setText(product.getDname());
        holder.textViewShortDesc.setText(product.getDgen());
        holder.textViewRating.setText(product.getDemail());

        holder.textViewPrice.setText(String.valueOf(product.getDmob()));
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle, textViewShortDesc, textViewRating, textViewPrice;
        ImageView imageView;

        public ProductViewHolder(View itemView) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewShortDesc = itemView.findViewById(R.id.textViewShortDesc);
            textViewRating = itemView.findViewById(R.id.textViewRating);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);

        }
    }
}
