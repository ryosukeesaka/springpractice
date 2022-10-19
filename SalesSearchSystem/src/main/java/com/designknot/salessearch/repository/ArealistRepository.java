package com.designknot.salessearch.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.designknot.salessearch.entity.ArealistMst;

@Mapper
public interface ArealistRepository {
	//エリア一覧の表示
	@Select("select "
    		+ "t1.area_name as area_name "
    		+ ",t1.area_cd as area_cd "//selectでarea_cdを持ってないとparameterとして送れない
    		+ ",sum(t6.price) as price "
    		+ "from "
    		+ "practice.area_mst t1 "
    		+ "left outer join "
    		+ "practice.pref_mst t4 "
    		+ "on "
    		+ "(t1.area_cd = t4.area_cd) "
    		+ "left outer join "
    		+ "practice.ms_mst t5 "
    		+ "on "
    		+ "(t4.pref_cd = t5.pref_cd) "
    		+ "left outer join "
    		+ "practice.uriage_daily t6 "
    		+ "on "
    		+ "(t5.ms_cd = t6.ms_cd) "
    		+ "left outer join "
    		+ "practice.item_mst t7 "
    		+ "on "
    		+ "(t6.item_cd = t7.item_cd) "
    		+ "where substring(t6.uriage_date,1,6) = #{nengetu}  "
    		+ "group by "
			+ "t1.area_name "
			+ ",t1.area_cd "
    		)
	@Results(id = "Mst", value = {
			@Result(column = "area_name", property = "area_name"),
			@Result(column = "area_cd", property = "area_cd"),
			@Result(column = "sum", property = "sum"),
			})
	  List<ArealistMst> findAll(String nengetu);

	//売上日の検索
	@Select("select "
			+ "concat"
    		+ "(substring(t1.uriage_date,1,4) "
    		+ ",'/', "
    		+ "substring(t1.uriage_date,5,2)) "
    		+ "as uriage_date "
    		+ "from "
    		+ "practice.uriage_daily t1 "
    		+ "group by "
    		+ "concat (substring(t1.uriage_date,1,4) "
    		+ " ,'/', "
    		+ "substring(t1.uriage_date,5,2)) "
    		+ "order by "
    		+ "concat (substring(t1.uriage_date,1,4) "
    		+ " ,'/', "
    		+ "substring(t1.uriage_date,5,2)) "
    		+ "desc")
	@Results(id = "Date", value = {
			@Result(column = "uriage_date", property = "uriage_date"),
			})
	List<ArealistMst> searchUriageDate();


}
