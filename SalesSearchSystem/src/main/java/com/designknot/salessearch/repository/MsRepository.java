package com.designknot.salessearch.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.designknot.salessearch.entity.MsMst;

@Mapper
public interface MsRepository {

	@Select("select "
			+ "t1.area_cd as area_cd "
			+ ",t1.area_name as area_name "
			+ ",t2.pref_name as pref_name "
			+ ",t2.pref_cd as pref_cd "
			+ ",t3.ms_name as ms_name "
			+ ",concat (substring(t4.uriage_date,1,4),'/',substring(t4.uriage_date,5,2)) as uriage_date "
			//+ ",t4.uriage_date as uriage_date "
			+ ",t5.item_name as item_name "
			+ ",t6.category_name "
			+ ",sum(t4.price) as price "
			+ "from "
			+ "practice.area_mst t1 "
			+ "left outer join "
			+ "practice.pref_mst t2 "
			+ "on "
			+ "(t1.area_cd = t2.area_cd) "
			+ "left outer join "
			+ "practice.ms_mst t3 "
			+ "on "
			+ "(t2.pref_cd = t3.pref_cd) "
			+ "left outer join "
			+ "practice.uriage_daily t4 "
			+ "on "
			+ "(t3.ms_cd = t4.ms_cd) "
			+ "left outer join "
			+ "practice.item_mst t5 "
			+ "on "
			+ "(t4.item_cd = t5.item_cd) "
			+ "left outer join "
			+ "practice.item_category_mst t6 "
			+ "on "
			+ "(t5.category_cd = t6.category_cd) "
			+ "where "
			+ "substring(t4.uriage_date,1,6) = #{uriage_date} "
			+ "and t2.pref_cd = #{pref_cd} "
			+ "group by "
			+ "t1.area_cd "
			+ ",t1.area_name "
			+ ",t2.pref_name "
			+ ",t3.ms_name "
			+ ",concat (substring(t4.uriage_date,1,4),'/',substring(t4.uriage_date,5,2)) "
			+ ",t5.item_name "
			+ ",t6.category_name "
			)
	@Results(id = "Ms", value = {
			@Result(column = "pref_name", property = "pref_name"),
			@Result(column = "pref_cd", property = "pref_cd"),
			@Result(column = "area_cd", property = "area_cd"),
			@Result(column = "area_name", property = "area_name"),
			@Result(column = "item_cd", property = "item_cd"),
			@Result(column = "item_name", property = "item_name"),
			@Result(column = "ms_name", property = "ms_name"),
			@Result(column = "uriage_date", property = "uriage_date"),
			@Result(column = "sum", property = "sum")
	})

	List<MsMst> findms(String pref_cd, String uriage_date);

	//商品カテゴリーの検索
	@Select("select "
			+ "t1.category_name "
			+ ",t1.category_cd "
			+ "from "
			+ "practice.item_category_mst t1 "
			+ "order by "
			+ "t1.category_cd asc "
			)
	@Results(id = "Category", value = {
			@Result(column = "category_name", property = "category_name"),
			@Result(column = "category_cd", property = "category_cd"),
	})
	List<MsMst> searchCategory();

	//商品名の検索
	@Select("select "
			+ "t1.item_name "
			+ ",t1.item_cd "
			+ "from "
			+ "practice.item_mst t1 "
			+ "order by "
			+ "t1.item_cd asc "
			)
	@Results(id = "Item", value = {
			@Result(column = "item_name", property = "item_name"),
			@Result(column = "item_cd", property = "item_cd"),
	})
	List<MsMst> searchItem();	
	
	@Select("select "
			+ "t1.area_cd as area_cd "
			+ ",t1.area_name as area_name "
			+ ",t2.pref_name as pref_name "
			+ ",t2.pref_cd as pref_cd "
			+ ",t3.ms_name as ms_name "
			+ ",concat (substring(t4.uriage_date,1,4),'/',substring(t4.uriage_date,5,2)) as uriage_date "
			//+ ",t4.uriage_date as uriage_date "
			+ ",t5.item_name as item_name "
			+ ",t6.category_name "
			+ ",sum(t4.price) as price "
			+ "from "
			+ "practice.area_mst t1 "
			+ "left outer join "
			+ "practice.pref_mst t2 "
			+ "on "
			+ "(t1.area_cd = t2.area_cd) "
			+ "left outer join "
			+ "practice.ms_mst t3 "
			+ "on "
			+ "(t2.pref_cd = t3.pref_cd) "
			+ "left outer join "
			+ "practice.uriage_daily t4 "
			+ "on "
			+ "(t3.ms_cd = t4.ms_cd) "
			+ "left outer join "
			+ "practice.item_mst t5 "
			+ "on "
			+ "(t4.item_cd = t5.item_cd) "
			+ "left outer join "
			+ "practice.item_category_mst t6 "
			+ "on "
			+ "(t5.category_cd = t6.category_cd) "
			+ "where "
			+ "substring(t4.uriage_date,1,6) = #{uriage_date} "
			+ "and t2.pref_cd = #{pref_cd} "
			+ "and t6.category_name = #{category_name} "
			+ "and t5.item_name = #{item_name} "
			+ "group by "
			+ "t1.area_cd "
			+ ",t1.area_name "
			+ ",t2.pref_name "
			+ ",t3.ms_name "
			+ ",concat (substring(t4.uriage_date,1,4),'/',substring(t4.uriage_date,5,2)) "
			+ ",t5.item_name "
			+ ",t6.category_name "
			)
	@Results(id = "All", value = {
			@Result(column = "pref_name", property = "pref_name"),
			@Result(column = "pref_cd", property = "pref_cd"),
			@Result(column = "area_cd", property = "area_cd"),
			@Result(column = "area_name", property = "area_name"),
			@Result(column = "ms_name", property = "ms_name"),
			@Result(column = "uriage_date", property = "uriage_date"),
			@Result(column = "item_name", property = "item_name"),
			@Result(column = "category_name", property = "category_name"),
			@Result(column = "sum", property = "sum")
	})

	List<MsMst> findall(String pref_cd, String uriage_date, String category_name, String item_name);
}
