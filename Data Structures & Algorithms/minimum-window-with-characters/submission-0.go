
func minWindow(s string, t string) string {
    hash := make(map[rune]int)
    currHash := make(map[rune]int)
    result := ""
    minSize := int(1e9)
    startFlag := true
    for _, char := range t {
        hash[char] += 1
        currHash[char] += 1
    }
    fmt.Println("len of hash", hash, len(hash))
    i, j := 0,0
    for j < len(s) {
        fmt.Println("iterating over", j , s[j])
        if len(currHash) > 0 && (j-i)<minSize{
            // here we have to move end.
            fmt.Println("moving end")
            if _, ok := currHash[rune(s[j])]; ok{
                currHash[rune(s[j])] -= 1
                if currHash[rune(s[j])] == 0{
                    delete(currHash, rune(s[j]))
                }
                if startFlag {
                    i = j
                    startFlag = false
                }  
            }
            
            j++
        }else{
            //  here we have to move start
            // but before moving start get that substring
            fmt.Println("moving front")
            if i<=j && (j-i) < minSize {
                currResult := s[i:j]
                if len(currResult) < minSize{
                    result = currResult
                    minSize = len(currResult)
                }
            }
            
            currHash[rune(s[i])]++
            i++
            for i<j {
                if _, ok := hash[rune(s[i])]; !ok{
                    i++
                }else{
                    if _, ok :=currHash[rune(s[i])]; ok{
                        currHash[rune(s[i])]--
                        if currHash[rune(s[i])] == 0{
                            delete(currHash, rune(s[i]))
                        }
                    }
                    
                    break
                }
            }
            
        }
        fmt.Println(i,j,minSize,result, currHash)
    }
    if len(currHash) == 0{
        currResult := s[i:j]
        if len(currResult) <= minSize{
            result = currResult
            minSize = len(currResult)
        }
    }
    // last check 
    for i := len(result)-1; i>=0; i-- {
        if _, ok := hash[rune(result[i])]; ok{
            hash[rune(result[i])]--;
            if hash[rune(result[i])]==0{
                delete(hash, rune(result[i]))
                if len(hash) == 0{
                    result = result[i:]
                    break
                }
            }
        }
    }
    return result
}