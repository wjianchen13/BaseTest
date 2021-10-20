package com.example.test.loop;

import java.util.ArrayList;
import java.util.List;

/**
 * 实现循环播放需求，初始数据100条
 * 定时播放，新插入的数据在播放数据之后，删除最旧的一条
 * 
 * 实现：
 * 定义一个orginDatas，用来缓存100条数据的顺序，这里面的数据都可以视为 已经播放过一次
 * 定义一个showDatas，用来控制播放的实际数据
 * List item里面弄一个是否最新的标志，判断这条数据有没有被播放过，如果有，设置成0，没有设置成1
 * 如果插入数据，从List2播放index的下一个开始查找，直到找到标志=0，把该数据插入到这个item后面
 * 删除List1<>最前面一条，删除List2里面对应List1的一条，把新加入的数据插入到List1后面
 * 由于删除了List2的一条数据，里面的index要减1
 */
public class LoopManager {

    private static LoopManager DINO_INSTANCE = null;
    
    private static final int NUM = 5;

    /**
     * 原始数据
     */
    private List<Item> orginDatas = null;

    /**
     * 显示数据
     */
    private List<Item> showDatas = null;

    /**
     * 当前播放数据的下标
     */
    private int playIndex;
    
    public static LoopManager getInstance() {
        if (DINO_INSTANCE == null) {
            synchronized (LoopManager.class) {
                if (DINO_INSTANCE == null) {
                    DINO_INSTANCE = new LoopManager();
                }
            }
        }
        return DINO_INSTANCE;
    }

    public LoopManager() {
        this.orginDatas = new ArrayList<>();
        this.showDatas = new ArrayList<>();
        playIndex = 0;
    }

    /**
     * 添加首批数据，统一添加到数组末尾
     * @param datas
     */
    public synchronized void addData(List<Item> datas) {
        if (orginDatas == null)
            orginDatas = new ArrayList<>();
        orginDatas.clear();
        orginDatas.addAll(datas);
        if (showDatas == null)
            showDatas = new ArrayList<>();
        showDatas.clear();
        showDatas.addAll(datas);
        playIndex = 0;
        System.out.println("=====================================================> 加载数据");
        log1();
    }

    /**
     * 获取下一个播放的数据
     */
    public synchronized Item getItem() {
        Item item = null;
        if(showDatas != null && showDatas.size() > playIndex) {
            item = showDatas.get(playIndex ++);
            item.setIsShow(0);
            if(playIndex >= NUM) {
                playIndex = 0;
            }
        }
        System.out.println("=====================> playIndex: " + playIndex);
        return item;
    }

    /**
     * 减少index
     */
    private void decreaseIndex() {
        
    }

    /**
     * 插入一个数据
     * @param item
     * @return
     */
    public synchronized boolean insertItem(Item item) {
        if(orginDatas != null && showDatas != null) {
            item.setIsShow(1);
            Item delItem = orginDatas.get(0);
            orginDatas.remove(delItem);
            orginDatas.add(item);
            
            int insertIndex = getInsertIndex(playIndex);
            showDatas.add(insertIndex, item);
            
            int deleteIndex = showDatas.indexOf(delItem);
            showDatas.remove(delItem);
            
            if(playIndex > 0 && playIndex > deleteIndex) {
                playIndex --;
            }
            
            /**
             * 1.如果index = 0
             * 如果后面没有新数据，直接在index=0的位置插入新数据 1
             * 如果右面有新数据，在新数据后面插入数据 2
             * 2.如果index > 0
             * 如果1不是新数据，直接在index位置插入数据 1
             * 如果1是新数据，则查找1后面第一个非新数据的位置插入数据
             * 3.插入之后需要移除一个最旧的item，移除的item可能在index 前面，也可能在index 后面
             * 移除之后，判断index-1是不是新数据，如果是新数据，index - 1
             * 如果不是新数据，可能有2中情况
             */
//            if(playIndex > 0 && showDatas.get(playIndex - 1).getIsShow() == 1){ // 在最开始位置插入，不需要处理playIndex
//                playIndex --;
//            }


            
//            if(showDatas.get(playIndex).getIsShow() == ) {
//                
//            } else 
//            
//            showDatas.remove(delItem);
//            if(playIndex > 0) { // 数据可能在当前播放数据前面或者后面，删除掉前面的数据 playIndex 应该-1
//                Item tItem = showDatas.get(playIndex - 1);
//                if(tItem.getIsShow() == 1) { // 说明删除了前面的
//                    playIndex --;
//                    int insertIndex = getInsertIndex(playIndex);
//                    showDatas.add(insertIndex, item);
//                } else {
//                    int insertIndex = getInsertIndex(playIndex);
//                    showDatas.add(insertIndex, item);
//                }
//            } else { // 正好最后一个在播放 playIndex = 0, 删除之后直接往后面插入
////                playIndex = NUM - 1;
//                int insertIndex = getInsertIndex(playIndex);
//                showDatas.add(insertIndex, item);
//            }
//            System.out.println("=====================================================> 插入数据");
            log1();
            return true;
        } else {
            return false;
        }
    }
    
    private void log1() {
        for(int i = 0; i < orginDatas.size(); i ++) {
            System.out.println("=======================> orginDatas[" + i + "]: " + orginDatas.get(i).getName() + "   isShow: " + orginDatas.get(i).getIsShow());
        }

        for(int i = 0; i < showDatas.size(); i ++) {
            System.out.println("=======================> showDatas[" + i + "]: " + showDatas.get(i).getName() + "   isShow: " + showDatas.get(i).getIsShow());
        }
    }

    /**
     * 获取插入数据的index，因为当前播放的index后面也可能有新插入的数据
     * 要在新插入的数据后面插入
     * @param playIndex 从当前index开始查找
     * @return
     */
    private synchronized int getInsertIndex(int playIndex) {
        int index = 0;
        if(showDatas != null) {
            for (int i = playIndex; i < showDatas.size(); i ++) {
                if(showDatas.get(i).getIsShow() == 0) {
                    index = i;
                    break;
                }
            }
        }
        return index;
    }
    
    
    
}
