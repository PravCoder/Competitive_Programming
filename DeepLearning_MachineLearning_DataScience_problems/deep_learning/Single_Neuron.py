# Single Neuron
# https://www.deep-ml.com/problems/24
# Deep-ML

import math

def single_neuron_model(features: list[list[float]], labels: list[int], weights: list[float], bias: float) -> (list[float], float):

    # get the number of features is length of features matrix
    num_examples = len(features)

    # list of weighted sums per example
    weighted_sums = []
    # iterate all examples
    for i in range(num_examples):
        # weighted sum z = wx + wx +b for cur-example
        cur_weighted_sum = 0
        # iterate all the inputs into this node (the connections to this node usually all the nodes in preivous layer which is input layer), jth is the index of the node in previous layer
        for j in range(len(features[i])):
            # for the current example-features, get the jth feature-node-input
            cur_feature = features[i][j]
            cur_weighted_sum += (cur_feature * weights[j])

        # after itearting all previous nodes connected to this code and computing weighted-sum for node
        cur_weighted_sum += bias    # add bias
        weighted_sums.append(cur_weighted_sum)

    # after computing weighted-sum for all examples, compute sigmoid
    # stores sigmoid acitvation for every example
    probabilities = []
    for weighted_sum in weighted_sums:
        probabilities.append(1 / (1 + math.exp(-weighted_sum)))

    mse = 0
    # iteatea all examples, probs = [0.92, 0.12, 0.56]
    for i in range(len(probabilities)):
        predicted_prob = probabilities[i]   # get ith example predicted prob
        true_label = labels[i]              # get ith example true label

        mse += ((predicted_prob-true_label)**2) 

    # calc mean of squared errors
    mse = mse / len(probabilities)

    
	return probabilities, mse

