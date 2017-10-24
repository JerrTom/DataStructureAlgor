package com.aixin.cn;
/**
 * ����̽�ⷽ����ʵ��
 * @author JINXIN
 *
 * @param <K>
 * @param <V>
 */
public class LinearProbingHashMap<K, V> {

	private int num;//��ֵ����
	private int catacity;//Ͱ������(����)
	private K[] keys;
	private V[] values;
	
	@SuppressWarnings("unchecked")
	public LinearProbingHashMap(int initCatacity){
		keys = (K[])new Object[catacity];
		values = (V[])new Object[catacity];
		this.catacity = initCatacity;
	}
	//��̬���������С
	public void resize(int newCatacity){
		LinearProbingHashMap<K, V> hashMap = new LinearProbingHashMap<>(newCatacity);
		for(int i = 0;i<catacity;i++){
			if(keys[i] != null){
				hashMap.put(keys[i], values[i]);
			}
		}
		keys = hashMap.keys;
		values = hashMap.values;
		catacity = newCatacity;
	}
	
	public int hash(K key){
		return (key.hashCode() & 0x7fffffff) % catacity;
	}
	public void put(K key, V value){
		if(num>catacity/2){
			resize(2*catacity);
		}
		int index = hash(key);
		if(keys[index] != null || key.equals(keys[index])){
			index = (index+1) % catacity;
		}
		if(keys[index] == null){
			keys[index] = key;
			values[index] = value;
			return;
		}
		values[index] = value;
		num++;
	}
	public void delete(K key){
		//�ж��Ƿ������Ҫɾ����key
//		if(!contains(key)){
//			return;
//		}
		int index = hash(key);
		while(!key.equals(keys[index])){
			index = (index+1)%catacity; 
		}
		keys[index]=null;
		values[index]=null;
		index = (index+1)%catacity;
		while(keys[index] != null){
			K keyToRedo = keys[index];
			V valueToRedo = values[index];
			num--;
			keys[index] = null;
			values[index] = null;
			put(keyToRedo, valueToRedo);
		}
		num--;
		if(num>0 && num == catacity/8){
			resize(catacity/8);
		}
	}
}
