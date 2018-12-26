package windstudy.com.androidgopro.ListProduct;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import windstudy.com.androidgopro.R;

public class ListProductAdapter extends RecyclerView.Adapter<ListProductAdapter.ProductViewHolder>{
    ArrayList<ListProduct> arrData = new ArrayList<>();
    Context context;
    AdapterView.OnItemClickListener onItemClickListener;
    public interface  OnItemClickListener{
        void onItemClick(int position);


    }
    public void setOnItemClickListener(OnItemClickListener listener){
        onItemClickListener = (AdapterView.OnItemClickListener) listener;
    }




    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.product_item_layout,viewGroup,false);
        return new ProductViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder productViewHolder, int i) {
        ListProduct product = arrData.get(i);
        productViewHolder.tvPrice.setText(""+product.getPrice());
        productViewHolder.tvProduct.setText(""+product.getName());
        Picasso.get().load(product.getImages()).into(productViewHolder.imgProduct);

    }

    @Override
    public int getItemCount() {
        return arrData.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder {
        ImageView imgProduct;
        TextView tvProduct, tvPrice;


        public ProductViewHolder(View itemView) {
            super(itemView);
            imgProduct = itemView.findViewById(R.id.img_product);
            tvProduct = itemView.findViewById(R.id.txt_product_name);
            tvPrice = itemView.findViewById(R.id.txt_product_price);


        }
    }

}
