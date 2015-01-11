package com.hans.freeregex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class FreeMatcher {

	public static final FreeMatcher EMAIL = new FreeMatcher() {
		@Override
		public Matcher getMatcher(CharSequence sequence) {
			Pattern pattern = Pattern.compile("[\\w[.-]]+@[\\w[.-]]+\\.[\\w]+");
			return pattern.matcher(sequence);
		}
	};

	public static FreeMatcher anyOf(String regex) {
		return new FreeMatcher() {
			@Override
			public Matcher getMatcher(CharSequence sequence) {
				Pattern pattern = Pattern.compile(regex);
				return pattern.matcher(sequence);
			}
		};

	}

	abstract Matcher getMatcher(CharSequence sequence);

	public boolean matchesAllOf(CharSequence sequence) {
		return getMatcher(sequence).matches();
	}

	public boolean matchesAnyOf(CharSequence sequence) {
		Matcher m = getMatcher(sequence);
		m.reset();
		return m.find();
	}

	public String retainFirstFrom(CharSequence sequence) {
		Matcher m = getMatcher(sequence);
		if (m.find()) {
			return m.group();
		}
		return null;
	}

	public List<String> retainAllFrom(CharSequence sequence) {
		Matcher m = getMatcher(sequence);
		List<String> list = new ArrayList<>();
		while (m.find()) {
			list.add(m.group());
		}
		return list;
	}

	public String replaceFrom(CharSequence sequence, String replaceTo) {
		return null;
	}

	public String replaceFrom(CharSequence sequence, FreeType replaceTo) {
		Matcher m = getMatcher(sequence);
		StringBuffer buf = new StringBuffer();
		while (m.find()) {
			m.appendReplacement(buf, replaceTo.replace(m.group()));
		}
		m.appendTail(buf);
		return buf.toString();
	}
}
