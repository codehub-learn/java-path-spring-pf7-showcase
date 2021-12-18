package gr.codelearn.spring.showcase.app.transfer;

import lombok.Value;

@Value
public class KeyValue<K, V> {
	K key;
	V value;
}
