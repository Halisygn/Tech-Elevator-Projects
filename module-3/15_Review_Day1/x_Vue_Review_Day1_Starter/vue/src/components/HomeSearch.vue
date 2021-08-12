<template>
  <div>
    <div id="searchHomes">
      <label for="zip">Enter your zip code to find your dream home</label>
      <input type="text" name="zip" v-model="zipFilter" />
    </div>
    <p v-if="filteredHomes.length == 0">No results found!</p>
    <div class="divTable greenTable" v-if="filteredHomes.length > 0">
      <div class="divTableHeading">
        <div class="divTableRow">
          <div class="divTableHead">head1</div>
          <div class="divTableHead">MLS Number</div>
          <div class="divTableHead">Address</div>
          <div class="divTableHead">Description</div>
          <div class="divTableHead">Price</div>
        </div>
      </div>
      <div class="divTableBody">
        <div
          class="divTableRow"
          v-for="home in filteredHomes"
          :key="home.mlsNumber"
        >
          <div class="divTableCell">
            <img v-bind:src="require(`../assets/${home.imageName}`)" />
          </div>
          <div class="divTableCell">{{ home.mlsNumber }}</div>
          <div class="divTableCell">
            <p>{{ home.address.addressLine }}</p>
            <p>
              {{ home.address.city }} {{ home.address.state }}
              {{ home.address.zipCode }}
            </p>
          </div>
          <div class="divTableCell">{{ home.description }}</div>
          <div class="divTableCell">{{ home.price }}</div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "home-search",
  data() {
    return {
      zipFilter: "",
    };
  },
  computed: {
    filteredHomes() {
      return this.$store.state.homes.filter((home) => {
        return this.zipFilter == ""
          ? true
          : this.zipFilter == home.address.zipCode;
      });
    },
  },
};
</script>

<style>
#main-div {
  margin: 30px;
}

#searchHomes {
  margin: 30px;
}

input[type="text"] {
  margin: 30px;
  width: 15%;
  padding: 12px 17px;
  border: 2px solid green;
  border-radius: 6px;
}

img {
  width: 175px;
  height: auto;
}

div.greenTable {
  margin: auto;
  border: 2px solid #06b712;
  width: 80%;
  text-align: left;
  border-collapse: collapse;
}
.divTable.greenTable .divTableCell,
.divTable.greenTable .divTableHead {
  border: 1px solid #24943a;
  padding: 3px 2px;
}
.divTable.greenTable .divTableBody .divTableCell {
  font-size: 13px;
}
.divTable.greenTable .divTableHeading {
  background: #24943a;
  background: -moz-linear-gradient(top, #5baf6b 0%, #3a9e4d 66%, #24943a 100%);
  background: -webkit-linear-gradient(
    top,
    #5baf6b 0%,
    #3a9e4d 66%,
    #24943a 100%
  );
  background: linear-gradient(to bottom, #5baf6b 0%, #3a9e4d 66%, #24943a 100%);
  border-bottom: 0px solid #444444;
}
.divTable.greenTable .divTableHeading .divTableHead {
  font-size: 19px;
  font-weight: bold;
  color: #f0f0f0;
  text-align: left;
  border-left: 2px solid #24943a;
}
.divTable.greenTable .divTableHeading .divTableHead:first-child {
  border-left: none;
}

.greenTable .tableFootStyle {
  font-size: 13px;
}
.greenTable .tableFootStyle .links {
  text-align: right;
}
.greenTable .tableFootStyle .links a {
  display: inline-block;
  background: #ffffff;
  color: #24943a;
  padding: 2px 8px;
  border-radius: 5px;
}
.greenTable.outerTableFooter {
  border-top: none;
}
.greenTable.outerTableFooter .tableFootStyle {
  padding: 3px 5px;
}

.divTable {
  display: table;
}
.divTableRow {
  display: table-row;
}
.divTableHeading {
  display: table-header-group;
}
.divTableCell,
.divTableHead {
  display: table-cell;
}
.divTableHeading {
  display: table-header-group;
}
.divTableFoot {
  display: table-footer-group;
}
.divTableBody {
  display: table-row-group;
}
</style>