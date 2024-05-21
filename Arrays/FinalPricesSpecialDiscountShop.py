class Solution:
    def finalPrices(self, prices: List[int]) -> List[int]:
        
        answer = []
        for i in range(len(prices)):
            answer.append(prices[i]) # initlize prices with elemetns of prices in case for a item a discount
            # is not possible, so its final price is price[i]
            for j in range(i+1, len(prices)):
                if prices[j] <= prices[i]:
                    answer[i] = prices[i] - prices[j]
                    break

        return answer
    

# 1475. Final Prices With a Special Discount in a Shop