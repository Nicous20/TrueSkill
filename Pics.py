from trueskill import Rating, quality_1vs1, rate_1vs1


class Pics(object):
    id = ""
    rk = Rating()

    def __init__(self, id):
        self.id = id
        self.num = int(id)
        self.com_num = 0

    def get_id(self):
        return self.id

    def get_rk(self):
        return self.rk

    def win(self, opp, res):
        self.com_num += 1
        opp.com_num += 1
        if res == 1:
            self.rk, opp.rk = rate_1vs1(self.rk, opp.rk)
        elif res == -1:
            opp.rk, self.rk = rate_1vs1(opp.rk, self.rk)



