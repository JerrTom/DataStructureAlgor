package com.aixin.cn;

/**
 * ����������ʵ��
 * @author JINXIN
 *
 * @param <K>
 * @param <V>
 */
public class SeperateChainingHashSet<K, V> {

	private int maxSize;//��ǰɢ�б��м�ֵ�Ե�����
	private int catacity;//������Ͱ�ĸ�����
	private SeqSearchST<K, V>[] st;//�����������
	
	@SuppressWarnings("unchecked")
	public SeperateChainingHashSet(int initialCatacity) {
		catacity = initialCatacity;
		st = (SeqSearchST<K, V>[]) new Object[catacity];//��ʼ������(Ͱ)
		/*
		 * ѭ��ɢ��Ͱ����ÿһ��Ͱ����һ���������
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
