import java.util.*;
class solution {
    public static List<String> removeSubfolders(String[] folder) 
    {
        //sort the array
        Arrays.sort(folder);

        List<String> result=new ArrayList<>(); //result list

        result.add(folder[0]); //Add first folder in the result
        for(int i=1;i<folder.length;i++)
        {
            if(!folder[i].startsWith(result.get(result.size()-1)+"/")) //compare the last inserted folder in result with the new folders while traversing
            {
                result.add(folder[i]);
            }
        }

        return result;
        
    }
    public static void main(String[] args) 
    {
        //Sample example
        String[] folder = {"/a", "/a/b", "/c/d", "/c/d/e", "/c/f"};
        List<String> result = removeSubfolders(folder);
        System.out.println(result);  // Output: ["/a", "/c/d", "/c/f"]
    }
}