package org.anddev.game.items;

import java.io.InputStream;

public class WeaponList extends ItemList<WeaponItem> {
	
	/////////////////////////////////
	//	Constructors
	/////////////////////////////////
	public static WeaponList createEmpty() {
		return new WeaponList(WeaponItem.class);
	}
	public WeaponList(Class<WeaponItem> clazz) {
		super(clazz);
	}
	
	
	
	//////////////////////////////
	//	Public Methods
	//////////////////////////////
	public void initialize(InputStream ifile) {
		this.loadFromXML(ifile);
		this.sortLevelThenType();
	}
	public void sort() {
		this.sortLevelThenType();
	}
	
	
	
	
	
	
	
	
	
	///////////////////////
	// Private Methods
	///////////////////////
	private void sortLevelThenType() {
		// sort by level and then sub-sprt by wtype
		this.sortByLevel();
		this.subsortByType();
	}
	private void sortByLevel() {
		this.sortingList.sortByLevel();
	}
	
	private void subsortByType() {
		int start = 0;
		int end = 0;
		int curlvl = sortingList.get(0).getLevelRequired();
		int i = 1;
		while (i < sortingList.size()) {
			if (sortingList.get(i).getLevelRequired() != curlvl) {
				end = i;
				this.sortByType(start, end);
				start = i;
			}
			i++;
		}
		this.sortByType(start, sortingList.size());
	}
	protected void sortByType(int left, int right){
		// uses fixed-space quicksort
		if(left < right) {
			int pivotIndex = (right-left)/2 + left;
			int newPivotIndex = this.partitionType(left, right, pivotIndex);
			this.sortByType(left, newPivotIndex);
			this.sortByType(newPivotIndex+1, right);
		}
	}
	
	private int partitionType(int left, int right, int pivotIndex) {
		// swap pivot index to right end
		WeaponItem temp;
		WeaponItem pivot = sortingList.get(pivotIndex);
		sortingList.set(pivotIndex, sortingList.get(right-1));
		sortingList.set(right-1, pivot);
		
		int storeIndex = left;
		for(int i=left; i<right-1; i++) {
			
			if(ItemBase.WEPtype.compare(sortingList.get(i).getWepType(), pivot.getWepType()) < 0) {
				temp = sortingList.get(i);
				sortingList.set(i, sortingList.get(storeIndex));
				sortingList.set(storeIndex, temp);
				storeIndex++;
			}
		}
		// swap back pivot 
		sortingList.set(right-1, sortingList.get(storeIndex));
		sortingList.set(storeIndex, pivot);
		return storeIndex;
	}

}
