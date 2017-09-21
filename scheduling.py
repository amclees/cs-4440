def run_processes(processes):
    start_time = 0
    finish_time = 0
    total_wait = 0
    for process in processes:
        wait = finish_time - process[0]
        print(wait)
        total_wait += wait
        start_time = finish_time
        finish_time = start_time + process[1]
    print("avg: " + str(total_wait / len(processes)))

run_processes([[0, 4], [2, 6], [3, 8], [7, 12]])

