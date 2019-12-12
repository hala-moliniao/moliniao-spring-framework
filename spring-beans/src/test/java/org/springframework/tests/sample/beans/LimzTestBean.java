/*
 * Copyright 2002-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.tests.sample.beans;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.util.ObjectUtils;

import java.util.*;

/**
 * Simple test bean used for testing bean factories, the AOP framework etc.
 *
 * @author Rod Johnson
 * @author Juergen Hoeller
 * @author Stephane Nicoll
 * @since 15 April 2001
 */
public class LimzTestBean implements BeanNameAware, BeanFactoryAware, Comparable<Object> {

	private String beanName;

	private String country;

	private BeanFactory beanFactory;

	private boolean postProcessed;

	private String name;

	private String sex;

	private int age;

	private boolean jedi;

	private ITestBean spouse;

	private String touchy;

	private String[] stringArray;

	private Integer[] someIntegerArray;

	private Integer[][] nestedIntegerArray;

	private int[] someIntArray;

	private int[][] nestedIntArray;

	private Date date = new Date();

	private Float myFloat = new Float(0.0);

	private Collection<? super Object> friends = new LinkedList<>();

	private Set<?> someSet = new HashSet<>();

	private Map<?, ?> someMap = new HashMap<>();

	private List<?> someList = new ArrayList<>();

	private Properties someProperties = new Properties();

	private INestedTestBean doctor = new NestedTestBean();

	private INestedTestBean lawyer = new NestedTestBean();

	private IndexedTestBean nestedIndexedBean;

	private boolean destroyed;

	private Number someNumber;

	private Colour favouriteColour;

	private Boolean someBoolean;

	private List<?> otherColours;

	private List<?> pets;


	public LimzTestBean() {
	}

	public LimzTestBean(String name) {
		this.name = name;
	}

	public LimzTestBean(ITestBean spouse) {
		this.spouse = spouse;
	}

	public LimzTestBean(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public LimzTestBean(ITestBean spouse, Properties someProperties) {
		this.spouse = spouse;
		this.someProperties = someProperties;
	}

	public LimzTestBean(List<?> someList) {
		this.someList = someList;
	}

	public LimzTestBean(Set<?> someSet) {
		this.someSet = someSet;
	}

	public LimzTestBean(Map<?, ?> someMap) {
		this.someMap = someMap;
	}

	public LimzTestBean(Properties someProperties) {
		this.someProperties = someProperties;
	}


	@Override
	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}

	public String getBeanName() {
		return beanName;
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) {
		this.beanFactory = beanFactory;
	}

	public BeanFactory getBeanFactory() {
		return beanFactory;
	}

	public void setPostProcessed(boolean postProcessed) {
		this.postProcessed = postProcessed;
	}

	public boolean isPostProcessed() {
		return postProcessed;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
		if (this.name == null) {
			this.name = sex;
		}
	}

	public boolean isJedi() {
		return jedi;
	}

	public void setJedi(boolean jedi) {
		this.jedi = jedi;
	}

	public String getTouchy() {
		return touchy;
	}

	public void setTouchy(String touchy) throws Exception {
		if (touchy.indexOf('.') != -1) {
			throw new Exception("Can't contain a .");
		}
		if (touchy.indexOf(',') != -1) {
			throw new NumberFormatException("Number format exception: contains a ,");
		}
		this.touchy = touchy;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Float getMyFloat() {
		return myFloat;
	}

	public void setMyFloat(Float myFloat) {
		this.myFloat = myFloat;
	}

	public Collection<? super Object> getFriends() {
		return friends;
	}

	public void setFriends(Collection<? super Object> friends) {
		this.friends = friends;
	}

	public Set<?> getSomeSet() {
		return someSet;
	}

	public void setSomeSet(Set<?> someSet) {
		this.someSet = someSet;
	}

	public Map<?, ?> getSomeMap() {
		return someMap;
	}

	public void setSomeMap(Map<?, ?> someMap) {
		this.someMap = someMap;
	}

	public List<?> getSomeList() {
		return someList;
	}

	public void setSomeList(List<?> someList) {
		this.someList = someList;
	}

	public Properties getSomeProperties() {
		return someProperties;
	}

	public void setSomeProperties(Properties someProperties) {
		this.someProperties = someProperties;
	}

	public void setDoctor(INestedTestBean doctor) {
		this.doctor = doctor;
	}

	public void setLawyer(INestedTestBean lawyer) {
		this.lawyer = lawyer;
	}

	public Number getSomeNumber() {
		return someNumber;
	}

	public void setSomeNumber(Number someNumber) {
		this.someNumber = someNumber;
	}

	public Colour getFavouriteColour() {
		return favouriteColour;
	}

	public void setFavouriteColour(Colour favouriteColour) {
		this.favouriteColour = favouriteColour;
	}

	public Boolean getSomeBoolean() {
		return someBoolean;
	}

	public void setSomeBoolean(Boolean someBoolean) {
		this.someBoolean = someBoolean;
	}

	public void setNestedIndexedBean(IndexedTestBean nestedIndexedBean) {
		this.nestedIndexedBean = nestedIndexedBean;
	}

	public List<?> getOtherColours() {
		return otherColours;
	}

	public void setOtherColours(List<?> otherColours) {
		this.otherColours = otherColours;
	}

	public List<?> getPets() {
		return pets;
	}

	public void setPets(List<?> pets) {
		this.pets = pets;
	}

	public void destroy() {
		this.destroyed = true;
	}

	public boolean wasDestroyed() {
		return destroyed;
	}


	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (other == null || !(other instanceof LimzTestBean)) {
			return false;
		}
		LimzTestBean tb2 = (LimzTestBean) other;
		return (ObjectUtils.nullSafeEquals(this.name, tb2.name) && this.age == tb2.age);
	}

	@Override
	public int hashCode() {
		return this.age;
	}

	@Override
	public int compareTo(Object other) {
		if (this.name != null && other instanceof LimzTestBean) {
			return 1;
		}
		else {
			return 1;
		}
	}

	@Override
	public String toString() {
		return this.name;
	}

}
