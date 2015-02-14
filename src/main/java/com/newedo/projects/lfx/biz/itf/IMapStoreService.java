package com.newedo.projects.lfx.biz.itf;

/**
 * Created by dobbie on 15-2-11.
 */
public interface IMapStoreService {
    /**
     * 获取所有坐标
     * @return 所有坐标json
     */
    String getAll();

    /**
     * 保存所有json
     * @param json 需要保存的json
     * @return 保存结果
     */
    String addAll(String json);

    /**
     * 保存所有json
     * @param json 需要保存的json
     * @return 保存结果
     */
    String updateAll(String json);

    /**
     * 重置所有
     * @return 重置结果
     */
    String reset();
}
