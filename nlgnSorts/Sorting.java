//Benjamin Schreyer 11/2/2020
public class Sorting 
{
	public static void mergeSort(int[] sort)
	{
		mergeSort(sort, 0, sort.length-1);
	}
	public static void mergeSort(int[] sort, int s, int e)
	{
		//split and merge sublists if the list is longer than 1
		if(e > s)
		{
			mergeSort(sort, s, (e-s)/2 + s);
			mergeSort(sort, (e-s)/2 + s+1, e);
			merge(sort, s, (e-s)/2 + s, (e-s)/2 + s+1, e);
		}
		else
		{
			return;
		}
		
	}
	public static void merge(int[] sort, int s1, int e1, int s2, int e2)
	{
		//combine two sorted sublists
		int i = 0;
		int j = 0;
		int wh = s1;
		int[] l1 = new int[e1-s1+1];
		int[] l2 = new int[e2-s2+1];
		for(int k = s1;k <= e1;k++)
		{
			l1[k-s1] = sort[k];
		}
		for(int k = s2;k <= e2;k++)
		{
			l2[k-s2] = sort[k];
		}
		while(i < e1-s1+1 && j < e2-s2+1)
		{
			if(l1[i] < l2[j])
			{
				sort[wh] = l1[i];
				i++;
			}
			else
			{
				sort[wh] = l2[j];
				j++;
			}
			wh++;
		}
		while(i < e1-s1+1)
		{
			sort[wh] = l1[i];
			i++;
			wh++;
		}
		while(j < e2-s2+1)
		{
			sort[wh] = l2[j];
			j++;
			wh++;
		}
	}
	
	public static void siftDown(int[] sort, int pos, int high)
	{
		//repair subtree to low-high has heap condition
		int root = pos;
		while(2*root + 1 <= high)
		{
			int largestInd = root;
			if(sort[largestInd] < sort[2*root + 1])
			{
				largestInd = 2*root + 1;
			}
			if(2*root + 2 <= high&&sort[largestInd] < sort[2*root + 2]  )
			{
				largestInd =2*root + 2;
			}
			if(root == largestInd)
			{
				break;
			}
			int t = sort[root];
			sort[root] = sort[largestInd];
			sort[largestInd] = t;
			root = largestInd;
		}
	}
	
	public static void heapSort(int[] sort)
	{
		int par = (sort.length - 1) / 2;
		
		//heapify
		while(par >= 0)
		{
			siftDown(sort, par, sort.length - 1);
			par-=1;
		}
		//remove and repair from heap, place removed at end(biggest)
		int end = sort.length-1;
		while(end > 0)
		{
			int t = sort[end];
			sort[end] = sort[0];
			sort[0] = t;
			end--;
			siftDown(sort, 0, end);
			
		}
	}
	public static void quickSort(int[] sort)
	{
		quickSort(sort,0,sort.length-1);
	}
	public static void quickSort(int[] sort,int start, int end)
	{
		//dont split lists of length 1 or 0
		if(start >= end)
		{
			return;	
		}
		//middle index and middle
		int mind = start+(end-start)/2;
		int middle = sort[mind];
		int[] lc = new int[end-start+1];
		//copy list
		for(int i = start;i <= end;i++)
		{
			lc[i-start] = sort[i];
		}

		int mindP = start;
		int wh = start;
		//re write list following pivot rules
		for(int i = 0;i < lc.length;i++)
		{
			if(lc[i] < middle)
			{
				sort[wh] = lc[i];
				wh++;
				mindP++;
			}
		}
		int mindP2 = mindP;
		for(int i = 0;i < lc.length;i++)
		{
			if(lc[i] == middle)
			{
				sort[wh] = lc[i];
				wh++;
				mindP2++;
			}
		}
		for(int i = 0;i < lc.length;i++)
		{
			if(lc[i] > middle)
			{
				sort[wh] = lc[i];
				wh++;
			}
		}
		//sort two halfs around pivot ignoring equal regions
		quickSort(sort,start,mindP-1);
		quickSort(sort,mindP2,end);
	}
	
	public static void main(String[] args)
	{
		int[] merge = {2, 6, 6 ,34 ,34 , 122, 255, 19 ,3 ,1, 0, -1 ,26};
		
		for(int i : merge)
		{
			System.out.print("  " + i);
		}
		System.out.println("\n"+merge);
		mergeSort(merge);
		for(int i : merge)
		{
			System.out.print("  " + i);
		}
		System.out.println("\n"+merge);
		
		int[] heap = {2, 6, 6 ,34 ,34 , 122, 255, 19 ,3 ,1, 0, -1 ,236,929,42,153,67,-134,544444, -3, 2, 1, 0 , 23};
		
		for(int i : heap)
		{
			System.out.print("  " + i);
		}
		System.out.println("\n"+heap);
		heapSort(heap);
		for(int i : heap)
		{
			System.out.print("  " + i);
		}
		System.out.println("\n"+heap);
		
		int[] quick = {2, 6, 6 ,34 ,34 , 122, 255, 19 ,3 ,1, 0, -1,-32,32,53,53,53,53,53 ,23236,99,42,153,67,-134,544444};
		
		for(int i : quick)
		{
			System.out.print("  " + i);
		}
		System.out.println("\n"+quick);
		quickSort(quick);
		for(int i : quick)
		{
			System.out.print("  " + i);
		}
		System.out.println("\n"+quick);
	}

}
