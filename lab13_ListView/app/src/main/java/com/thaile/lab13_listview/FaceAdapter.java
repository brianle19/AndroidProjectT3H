package com.thaile.lab13_listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Le on 7/14/2016.
 */
public class FaceAdapter extends BaseAdapter {

    private ArrayList<ItemFace> listItemFace = new ArrayList<>();
    LayoutInflater layoutInflater;

    public void initData(){
      //  for (int i = 0; i < 10000 ; i++) {
            listItemFace.add(new ItemFace(R.drawable.ic_angry, "Angry"));
            listItemFace.add(new ItemFace(R.drawable.ic_beauty, "Beauty"));
            listItemFace.add(new ItemFace(R.drawable.ic_cry, "Cry"));
            listItemFace.add(new ItemFace(R.drawable.ic_love, "Love"));
            listItemFace.add(new ItemFace(R.drawable.ic_smile, "Smile"));
            listItemFace.add(new ItemFace(R.drawable.ic_asleep, "Sleep"));
            listItemFace.add(new ItemFace(R.drawable.ic_canny, "Canny"));
            listItemFace.add(new ItemFace(R.drawable.ic_angry, "Angry"));
            listItemFace.add(new ItemFace(R.drawable.ic_beauty, "Beauty"));
            listItemFace.add(new ItemFace(R.drawable.ic_cry, "Cry"));
            listItemFace.add(new ItemFace(R.drawable.ic_love, "Love"));
            listItemFace.add(new ItemFace(R.drawable.ic_smile, "Smile"));
            listItemFace.add(new ItemFace(R.drawable.ic_asleep, "Sleep"));
            listItemFace.add(new ItemFace(R.drawable.ic_canny, "Canny"));
            listItemFace.add(new ItemFace(R.drawable.ic_angry, "Angry"));
            listItemFace.add(new ItemFace(R.drawable.ic_beauty, "Beauty"));
            listItemFace.add(new ItemFace(R.drawable.ic_cry, "Cry"));
            listItemFace.add(new ItemFace(R.drawable.ic_love, "Love"));
            listItemFace.add(new ItemFace(R.drawable.ic_smile, "Smile"));
            listItemFace.add(new ItemFace(R.drawable.ic_asleep, "Sleep"));
            listItemFace.add(new ItemFace(R.drawable.ic_canny, "Canny"));
     //   }

    }

    @Override
    public int getCount() {
        //lấy ds số lượng trong itemFace
        //số lượng phần tử dsach itemFace
        //return list.size
        return listItemFace.size();
    }

    @Override
    public ItemFace getItem(int position) {
        //trả về 1 đôi tượng khi click vào nó itemFace tại 1 vị trí nào đó
        return listItemFace.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Khi lần đầu tiên vào, getView đc gọi đến -> để đổ lần lượt dữ liệu vào cái list view
        //khi kéo xuống thì lại gọi getView để đổ lên phần còn lại
        //kéo lại lên thì getView lại đc gọi để đổ lại vào

        //position: vị trí của data
        //convertView: item tại 1 vị trí hiện tại của listview khi chưa kéo.  hành động đổ dữ liệu lại 1 vị trí nào đó trong dsach data vào itemview để có
        // 1 itemview có dữ liệu.

        //parent: là cái listView

        //lần đầu tiên tại vị trí i của listView, itemView = null
        //thì cta ánh xạ itemView từ thư mục res ra'

        //khởi tạo cái túi
        ViewHolder viewHolder;
        //hàm if: chạy đúng 1 lần
        if (convertView == null){
            convertView = layoutInflater.inflate(R.layout.item_face, parent, false);
            //tạo cái túi
            viewHolder = new ViewHolder();

            //nhét 2 cái item vào túi
            viewHolder.ivFace = (ImageView) convertView.findViewById(R.id.imgFace);
            viewHolder.tvFace = (TextView) convertView.findViewById(R.id.txtvName);

            //gán viewholder vào cho View cha
            convertView.setTag(viewHolder);

        } else {
            //lôi dữ liệu trong túi ra
            viewHolder = (ViewHolder) convertView.getTag();
        }

        //để đổ dữ liệu vào cho nó vào vị trí position
//        ImageView ivFace = (ImageView) convertView.findViewById(R.id.imgFace);
//        TextView tvFace = (TextView) convertView.findViewById(R.id.txtvName);

//        ItemFace itemFace = listItemFace.get(position);
//        //đc ràng buộc bởi getCount() và getItemId()
//        ivFace.setImageResource(itemFace.getIdFace());
//        tvFace.setText(itemFace.getName());

        ItemFace itemFace = listItemFace.get(position);
        //đc ràng buộc bởi getCount() và getItemId()
        viewHolder.ivFace.setImageResource(itemFace.getIdFace());
        viewHolder.tvFace.setText(itemFace.getName());

        return convertView;
    }

    public FaceAdapter(Context context){
        layoutInflater = LayoutInflater.from(context);
        initData();
    }

    public void deleteItem(int position) {
        listItemFace.remove(position);
        //update lại giao diện cho listview khi 1 phần tử trong array bị xóa đi
        notifyDataSetChanged();
    }

    private class ViewHolder{
        ImageView ivFace;
        TextView tvFace;

    }
}
