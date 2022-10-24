from Pics import Pics
import numpy as np
from sklearn.preprocessing import normalize
import pandas as pd
import MySQLdb
from openpyxl import load_workbook
import time

db = MySQLdb.connect(
    host="dev.metattri.com",    # 主机名
    user="root",         # 用户名
    passwd="xbz123456",  # 密码
    db="true_skill",
    port=3308)

cur = db.cursor()

forder_name = ['' for i in range(500)]
cur.execute("SELECT * FROM ItemId")
for row in cur.fetchall():
    forder_name[int(row[1])] = row[0]

attr_ls = ["scale","space","green","facility"]
attr = "scale"
dic = {'scale': '规模适宜性', 'space':'空间舒适性', 'green':'绿化愉悦性', 'facility':'设施友好型'}


def comparison(n, attr):

    pic = [Pics(i) for i in range(n)]
    cur.execute("SELECT * FROM Comparison")
    for row in cur.fetchall():
        if row[0] == attr:
            idx1 = int(row[1])
            idx2 = int(row[2])
            Pics.win(pic[idx1], pic[idx2], int(row[3]))

    res = sorted(pic, key=lambda x:x.rk.mu, reverse=True)
    for i in range(n):
        xsl.loc[i] = [i + 1, forder_name[res[i].get_id()], res[i].rk.mu, res[i].com_num]
    xsl['score'] = normalize([xsl['score']])[0]
    xsl.to_excel(writer, sheet_name=dic[attr], index=False)
    # print('Rank')
    # for i in range(n):
    #     print('#RANK',i + 1, ' ==> ', res[i].get_id(), ' score = ', res[i].rk.mu, ' times = ', res[i].com_num)


time_start = time.time()
print("Start…………")

col = ['rank', 'folder_name', 'score', 'comparison_time']
xsl = pd.DataFrame(columns=col)
xsl.loc[0] = ['排名', '文件夹名', '得分', '比较次数']
xsl.to_excel('Result.xlsx', index=False)
book = load_workbook('Result.xlsx')
writer = pd.ExcelWriter('Result.xlsx')
writer.book = book

for attr in attr_ls:
    comparison(500, attr)

writer.save()


db.close()
time_end = time.time()
print("Finish…………")
print("Time ====> ", time_end - time_start)





