package com.aixin.cn;

/**
 * 拉链方法的实现
 * @author JINXIN
 *
 * @param <K>
 * @param <V>
 */
public class SeperateChainingHashSet<K, V> {

	private int maxSize;//当前散列表中键值对的总数
	private int catacity;//容量（桶的个数）
	private SeqSearchST<K, V>[] st;//链表对象数组
	
	@SuppressWarnings("unchecked")
	public SeperateChainingHashSet(int initialCatacity) {
		catacity = initialCatacity;
		st = (SeqSearchST<K, V>[]) new Object[catacity];//初始化数组(桶)
		/*
		 * 循环散列桶，给每一个桶创建一个链表对象
		 */
		for(int i = 0;i<st.length;i++){
			st[i] = new SeqSearchST<K, V>();
		}
	}
	
	private int hash(K key){
		return (key.hashCode() & 0x7fffffff) % catacity;
	}
	
	public V get(K key){
		return st[hash(key)].get(key);
	}
	
	public void put(K key, V value){
		st[hash(key)].put(key, value);
	}
}
