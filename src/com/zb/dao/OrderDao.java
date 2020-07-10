package com.zb.dao;

import com.zb.pojo.Order;
import com.zb.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OrderDao {

    public List<Order> findAll() throws Exception{
        Connection conn = DBUtils.getConnectionByDatasource();
        String sql = "select * from tb_order";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        Order order = new Order();
        List<Order> list = new ArrayList<>();
        while (rs.next()){
            order = new Order();
            order.setId(rs.getInt("id"));
            order.setOrder_id(rs.getInt("order_id"));
            order.setOrder_no(rs.getString("order_no"));
            order.setOrder_type(rs.getString("order_type"));
            order.setPnum(rs.getInt("pnum"));
            order.setCashier(rs.getString("cashier"));
            order.setOrder_time(rs.getString("order_time"));
            order.setPay_time(rs.getString("pay_time"));
            order.setPay_type(rs.getString("pay_type"));
            order.setPrice(rs.getDouble("price"));
            list.add(order);
        }
        System.out.println(list);
        DBUtils.close(conn);
        return list;
    }
}
