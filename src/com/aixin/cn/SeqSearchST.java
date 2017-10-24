package com.aixin.cn;
/**
 * 每个桶对应的链
 * @author JINXIN
 *
 * @param <K>
 * @param <V>
 */
public class SeqSearchST<K, V> {

	private Node first;
	
	private class Node{
		K key;
		V value;
		Node next;
		public Node(K key, V value, SeqSearchST<K, V>.Node next) {
			super();
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}
	
	public V get(K key){
		for(Node node=first;node!=null;node=node.next){
			if(key.equals(node.key)){
				return node.value;
			}
		}
		return null;
	}
	
	public void put(K key,V value){
		Node node;
		for(node=first; node!=null; node=node.next){
			if(key.equals(node.key)){
				node.value = value;
				return;
			}
		}
		first = new Node(key, value, first);
	}
}
