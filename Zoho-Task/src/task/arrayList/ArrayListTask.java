package task.arrayList;

import java.util.ArrayList;
import java.util.List;

import task.exception.InvalidInputException;
import task.util.HelperUtil;


public class ArrayListTask{


	public <T> List<T> getArrayList() {
		return new ArrayList<T>();
	}
	
	public <T> int size(List<T> list) throws InvalidInputException {
        HelperUtil.isNull(list);
        return list.size();
    }

    public <T> boolean add(List<T> list, T obj) throws InvalidInputException {
        HelperUtil.isNull(list);
        HelperUtil.isNull(obj);
        return list.add(obj);
    }
    

    public <T> int findIndexOf(List<T> list, T obj) throws InvalidInputException {
        HelperUtil.isNull(list);
        HelperUtil.isNull(obj);
        return list.indexOf(obj);
    }

    public <T> T findElementAt(List<T> list, int index) throws InvalidInputException {
        HelperUtil.isNull(list);
        HelperUtil.validateBoundary(size(list), index);
        return list.get(index);
    }

    public <T> int firstIndexOf(List<T> list, T obj) throws InvalidInputException {
        HelperUtil.isNull(list);
        HelperUtil.isNull(obj);
        return list.indexOf(obj);
    }

    public <T> int lastIndexOf(List<T> list, T obj) throws InvalidInputException {
        HelperUtil.isNull(list);
        HelperUtil.isNull(obj);
        return list.lastIndexOf(obj);
    }

    public <T> List<T> insertInBetween(List<T> list, T obj, int pos) throws InvalidInputException {
        HelperUtil.isNull(list);
        HelperUtil.isNull(obj);
        HelperUtil.validateBoundary(size(list), pos);
        list.add(pos, obj);
        return list;
    }

    public <T> List<T> mergeList(List<T> list1, List<T> list2, List<T> finalList) throws InvalidInputException {
        HelperUtil.isNull(list1);
        HelperUtil.isNull(list2);
        HelperUtil.isNull(finalList);
        finalList.addAll(list1);
        finalList.addAll(list2);
        return finalList;
    }

    public <T> List<T> mergeListRev(List<T> list1, List<T> list2, List<T> finalList) throws InvalidInputException {
        HelperUtil.isNull(list1);
        HelperUtil.isNull(list2);
        HelperUtil.isNull(finalList);
        finalList.addAll(list1);
        finalList.addAll(0, list2);
        return finalList;
    }

    public <T> List<T> deleteAt(List<T> list, int pos) throws InvalidInputException {
        HelperUtil.isNull(list);
        HelperUtil.validateBoundary(size(list), pos);
        list.remove(pos);
        return list;
    }

    public <T> List<T> removeCommonElements(List<T> inputList, int num) throws InvalidInputException {
        HelperUtil.isNull(inputList);
        HelperUtil.validateBoundary(size(inputList), num);
        List<T> list = inputList.subList(0, num);
        inputList.removeAll(list);
        return list;
    }

    public <T> List<T> retainCommonElements(List<T> inputList, int num) throws InvalidInputException {
        HelperUtil.isNull(inputList);
        HelperUtil.validateBoundary(size(inputList), num);
        List<T> list = inputList.subList(0, num);
        inputList.retainAll(list);
        return list;
    }

    public <T> List<T> removeAll(List<T> list) throws InvalidInputException {
        HelperUtil.isNull(list);
        list.clear();
        return list;
    }

    public <T> boolean isPresent(List<T> list, T obj) throws InvalidInputException {
        HelperUtil.isNull(list);
        HelperUtil.isNull(obj);
        return list.contains(obj);
    }

    public <T> List<T> createSubArrayList(List<T> list, int start, int end) throws InvalidInputException {
        HelperUtil.isNull(list);
        int size = size(list);
        HelperUtil.validateBoundary(size, end);
        HelperUtil.validateBoundary(size, start);
        HelperUtil.isStartLesserThanEnd(start, end);
        return list.subList(start, end);
    }


    
}
