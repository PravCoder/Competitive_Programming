# Compute Multi-class Cross-Entropy Loss
# Easy
# Deep-ML: https://www.deep-ml.com/problems/134

import numpy as np

def compute_cross_entropy_loss(predicted_probs: np.ndarray, true_labels: np.ndarray, epsilon = 1e-15) -> float:
    
    # get number of examples length of labels/probs
    num_examples = len(true_labels)
    # get number of output nodes length of one example-labels in true-labels-arr
    num_output_classes = len(true_labels[0])

    # stability
    predicted_probs = np.clip(predicted_probs, epsilon, 1 - epsilon)

    loss = 0

    # ierate all examples
    for i in range(num_examples):
        example_loss = 0.0  # stores loss for cur example
        # iterate all output nodes
        for j in range(num_output_classes):
            # accumulate loss for cur-example for jth node
            example_loss += (true_labels[i][j] * np.log(predicted_probs[i][j]))

        # accumlate loss for cr example
        loss += -example_loss

    # average the loss per example
    return loss/num_examples
    
