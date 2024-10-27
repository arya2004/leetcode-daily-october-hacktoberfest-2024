var isValid = function(s) {
    if(s.length%2 != 0)
        return false;
    let stack = []
    let top=-1;
    let obj = {
        "(": ")",
        "{": "}",
        "[": "]"
    }

    for(let i=0;i<s.length;i++){

        if(obj[s[i]]){
            stack.push(s[i]);
            top++;
        }
        else{
            if(obj[stack[top]] === s[i] && top>=0){
                stack.pop();
                top--;
            }
            else
                return false;
        }
    }
    if(stack.length > 0)
        return false;
    return true;
};